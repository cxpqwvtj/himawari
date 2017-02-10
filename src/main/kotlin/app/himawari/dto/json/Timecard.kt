// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * Timecard
 * @property yearMonth 年月
 * @property days 日次データ
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Timecard(
        var yearMonth: String? = null,
        var days: List<Days>? = null) {
    /**
     * 日次データ
     * @property bizDate 業務日
     * @property startDatetime 開始日時
     * @property endDatetime 終了日時
     * @property note 備考
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class Days(
            var bizDate: String? = null,
            var startDatetime: String? = null,
            var endDatetime: String? = null,
            var note: String? = null)
}