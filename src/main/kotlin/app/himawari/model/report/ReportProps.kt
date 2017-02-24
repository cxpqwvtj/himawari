package app.himawari.model.report

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * 帳票設定定義用クラスです。
 * Created by fukuda on 2017/02/24.
 */
@Component
class ReportProps(
        @Value("\${app.timecard.excel.template}") val templateFilePath: String,
        @Value("\${app.timecard.excel.outputSheetName}") val outputSheetName: String,
        @Value("\${app.timecard.excel.beginRowNum}") val beginRowNum: Int,
        @Value("\${app.timecard.excel.startDatetimeColumnIndex}") val startDatetimeColumnIndex: String,
        @Value("\${app.timecard.excel.endDatetimeColumnIndex}") val endDatetimeColumnIndex: String,
        @Value("\${app.timecard.excel.vacationTypeColumnIndex}") val vacationTypeColumnIndex: String,
        @Value("\${app.timecard.excel.noteColumnIndex}") val noteColumnIndex: String
)