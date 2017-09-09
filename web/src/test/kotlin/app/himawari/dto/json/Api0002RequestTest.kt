// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test

/**
 * Api0002Requestのテストクラスです
 */
internal class Api0002RequestTest {
    @Test
    fun fullProperty() {
        val api0002Request = Api0002Request().apply {
            days = listOf(Api0002Request.Day().apply {
                bizDate = ""
                startDatetime = ""
                endDatetime = ""
                vacationType = VacationType.PAID_DAY_OFF
                note = ""
            })
        }
        println(ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(api0002Request))
    }
}