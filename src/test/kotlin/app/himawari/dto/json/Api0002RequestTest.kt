// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

/**
 * Api0002Requestのテストクラスです
 */
internal class Api0002RequestTest {
    @Test
    fun fullProperty() {
        val api0002Request = Api0002Request().apply {
            days = listOf(Api0002Request.Days().apply {
                bizDate = ""
                startDatetime = ""
                endDatetime = ""
                vacationType = ""
                note = ""
            })
        }
        println(ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(api0002Request))
    }
}