// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test

/**
 * Api0003Responseのテストクラスです
 */
internal class Api0003ResponseTest {
    @Test
    fun fullProperty() {
        val api0003Response = Api0003Response().apply {
            resultType = ResultType.success
            message = ""
        }
        println(ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(api0003Response))
    }
}