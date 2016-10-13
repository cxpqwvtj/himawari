package app.himawari.dto.json

import java.util.*

/**
 * Created by masahiro on 2016/10/13.
 */
data class TimeCardListResponse(var result: List<TimeCard>) {
    data class TimeCard(var yearMonth: String)
}