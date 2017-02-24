package app.himawari.dto.report

/**
 * 帳票用の行クラスです。
 * Created by fukuda on 2017/02/24.
 */
class TimecardRow(
        val bizDate: String,
        val startDatetime: String,
        val endDatetime: String,
        val vacationType: String,
        val note: String
)