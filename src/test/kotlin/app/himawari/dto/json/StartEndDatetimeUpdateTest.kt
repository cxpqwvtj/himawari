// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

/**
 * StartEndDatetimeUpdateのテストクラスです
 */
internal class StartEndDatetimeUpdateTest {
    @Test
    fun fullProperty() {
        val startEndDatetimeUpdate = StartEndDatetimeUpdate().apply {
        }
        println(ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(startEndDatetimeUpdate))
    }
}