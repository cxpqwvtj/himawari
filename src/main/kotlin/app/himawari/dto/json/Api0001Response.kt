// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * 対象月の日次の開始/終了日時
 * @property yearMonth 年月
 * @property days 日次情報
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Api0001Response(
        var yearMonth: String? = null,
        var days: List<Day>? = null) {
    /**
     * 日次情報
     * @property bizDate 業務日
     * @property startDatetime 開始日時
     * @property endDatetime 終了日時
     * @property vacationTypeCode 休暇タイプ
     * @property note 備考
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class Day(
            var bizDate: String? = null,
            var startDatetime: String? = null,
            var endDatetime: String? = null,
            var vacationTypeCode: VacationTypeCode? = null,
            var note: String? = null) {
    
        enum class VacationTypeCode(val description: String) {
            PAID_DAY_OFF("有給休暇"),
            SP_DAY_OFF("特別休暇"),
            AM_OFF("AM休"),
            PM_OFF("PM休"),
            TRANSFER_DAY_OFF("振替休暇")
        }
    }
}
