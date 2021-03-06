// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test

/**
 * Api1002Responseのテストクラスです
 */
internal class Api1002ResponseTest {
    @Test
    fun fullProperty() {
        val api1002Response = Api1002Response().apply {
            users = listOf(Api1002Response.Users().apply {
                userId = ""
                userName = ""
            })
        }
        println(ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(api1002Response))
    }
}