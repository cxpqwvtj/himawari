package app.himawari.dto.json

import java.util.*

/**
 * Created by masahiro on 2016/10/13.
 */
data class TimeCardResponse(var result: TimeCard) {
    data class TimeCard(var yearMoth: String, var monthlyData: List<DailyData>) {
        data class DailyData(var startDate: Date, var endDate: Date)
    }
}
