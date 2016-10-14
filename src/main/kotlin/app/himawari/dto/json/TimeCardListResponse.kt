package app.himawari.dto.json

/**
 * Created by masahiro on 2016/10/13.
 */
data class TimeCardListResponse(var result: TimeCardList? = null,
                                var errorCode: String? = null,
                                var errorMessage: String? = null) {
    data class TimeCardList(val timecards: List<TimeCard> = listOf()) {
        data class TimeCard(var yearMonth: String)
    }
}
