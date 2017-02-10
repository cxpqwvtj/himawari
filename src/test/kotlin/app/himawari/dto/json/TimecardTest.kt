// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

/**
 * Timecardのテストクラスです
 */
internal class TimecardTest {
    @Test
    fun fullProperty() {
        val timecard = Timecard().apply {
            yearMonth = ""
            days = listOf(Timecard.Days().apply {
                bizDate = ""
                startDatetime = ""
                endDatetime = ""
                note = ""
            })
        }
        println(ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(timecard))
    }
}