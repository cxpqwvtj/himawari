package app.himawari.model.report

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.streaming.SXSSFWorkbook
import org.springframework.stereotype.Component
import java.io.File

/**
 * 帳票テンプレート管理クラスです。
 * Created by fukuda on 2017/02/24.
 */
@Component
class ReportTemplateManager(private val reportProps: ReportProps) {
    fun excelTemplate(): Workbook {
        val file = File(reportProps.templateFilePath)
        return if (file.exists()) {
            WorkbookFactory.create(file)
        } else {
            val workbook = SXSSFWorkbook()
            val sheet = workbook.createSheet(reportProps.outputSheetName)
            (0..50).map { sheet.createRow(it) }.map { row ->
                (0..5).map { cellIndex ->
                    row.createCell(cellIndex)
                }
            }
            sheet.trackAllColumnsForAutoSizing()
            workbook
        }
    }
}