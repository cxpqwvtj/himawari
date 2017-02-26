package app.himawari.service.report

import app.himawari.dto.json.VacationType
import app.himawari.dto.report.TimecardRow
import app.himawari.exbhv.TimecardDayBhv
import app.himawari.model.AppDate
import app.himawari.model.report.ReportProps
import app.himawari.model.report.ReportTemplateProvider
import org.apache.poi.ss.usermodel.Workbook
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters

/**
 * 帳票生成サービスです。
 * Created by fukuda on 2017/02/24.
 */
@Service
class ReportService(
        private val appDate: AppDate,
        private val reportTemplateProvider: ReportTemplateProvider,
        private val reportProps: ReportProps,
        private val timecardDayBhv: TimecardDayBhv
) {
    fun createXlsx(yearMonth: LocalDate, userId: String): Workbook {
        val workbook = reportTemplateProvider.reportTemplateManager.excelTemplate()
        val sheet = workbook.getSheet(reportProps.outputSheetName)

        val list = timecardDayBhv.selectList { cb ->
            cb.setupSelect_DailyStartEndAsCurrentValue()
            cb.query().setBizDate_FromTo(yearMonth, yearMonth, { option -> option.compareAsMonth() })
            cb.query().queryMember().setMemberAccountId_Equal(userId)
            cb.query().addOrderBy_BizDate_Asc()
        }
        val firstDayOfMonth = yearMonth.with(TemporalAdjusters.firstDayOfMonth())
        val lastDayOfMonth = yearMonth.with(TemporalAdjusters.lastDayOfMonth())
        val rows = (0..ChronoUnit.DAYS.between(firstDayOfMonth, lastDayOfMonth)).map { dayIndex ->
            val bizDate = appDate.toDate(firstDayOfMonth.plusDays(dayIndex).atStartOfDay())
            val timecardDay = list.singleOrNull { it.bizDate.compareTo(firstDayOfMonth.plusDays(dayIndex)) == 0 }
            if (timecardDay?.dailyStartEndAsCurrentValue?.isPresent ?: false) {
                val day = timecardDay!!.dailyStartEndAsCurrentValue.get()
                TimecardRow(bizDate,
                        day.startDatetime?.format(DateTimeFormatter.ofPattern("HH:mm")) ?: "",
                        day.endDatetime?.format(DateTimeFormatter.ofPattern("HH:mm")) ?: "",
                        if (day.vacationTypeCode == null) "" else VacationType.valueOf(day.vacationTypeCode).description,
                        day.note ?: "")
            } else {
                TimecardRow(bizDate, "", "", "", "")
            }
        }
        rows.mapIndexed { i, timecardRow ->
            val row = sheet.getRow(reportProps.beginRowNum + i)
            val bizDateCell = row.getCell(reportProps.bizDateColumnIndex)
            bizDateCell.setCellValue(timecardRow.bizDate)
            val bizDateStyle = workbook.creationHelper.createDataFormat().getFormat("yyyy/MM/dd")
            val bizDateCellStyle = workbook.createCellStyle()
            bizDateCellStyle.dataFormat = bizDateStyle
            bizDateCell.cellStyle = bizDateCellStyle
            row.getCell(reportProps.startDatetimeColumnIndex).setCellValue(timecardRow.startDatetime)
            row.getCell(reportProps.endDatetimeColumnIndex).setCellValue(timecardRow.endDatetime)
            row.getCell(reportProps.vacationTypeColumnIndex).setCellValue(timecardRow.vacationType)
            row.getCell(reportProps.noteColumnIndex).setCellValue(timecardRow.note)
        }
        reportProps.autoSizeColumnIndexes.map {
            sheet.autoSizeColumn(it)
        }
        return workbook
    }
}