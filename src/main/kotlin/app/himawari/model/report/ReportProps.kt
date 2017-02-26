package app.himawari.model.report

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * 帳票設定定義用クラスです。
 * Created by fukuda on 2017/02/24.
 */
@Component
class ReportProps(
        @Value("\${app.timecard.excel.templateFilePath}") val templateFilePath: String,
        @Value("\${app.timecard.excel.downloadFileName}") val downloadFileName: String,
        @Value("\${app.timecard.excel.outputSheetName}") val outputSheetName: String,
        @Value("\${app.timecard.excel.beginRowNum}") val beginRowNum: Int,
        @Value("\${app.timecard.excel.bizDateColumnIndex}") val bizDateColumnIndex: Int,
        @Value("\${app.timecard.excel.startDatetimeColumnIndex}") val startDatetimeColumnIndex: Int,
        @Value("\${app.timecard.excel.endDatetimeColumnIndex}") val endDatetimeColumnIndex: Int,
        @Value("\${app.timecard.excel.vacationTypeColumnIndex}") val vacationTypeColumnIndex: Int,
        @Value("\${app.timecard.excel.noteColumnIndex}") val noteColumnIndex: Int,
        @Value("\${app.timecard.excel.autoSizeColumnIndexes}") val autoSizeColumnIndexes: List<Int>
)
