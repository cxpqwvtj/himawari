package app.himawari.service.api

import app.himawari.dto.json.Api0002Request
import app.himawari.model.HimawariUser
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate

/**
 * ApiServiceのテストクラスです。
 * Created by cxpqwvtj on 2017/02/12.
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
internal class ApiServiceTest {
    @Autowired
    lateinit var apiService: ApiService

    @Test
    fun selectMonthlyInOutData() {
        val data = apiService.selectMonthlyInOutData("kougami", LocalDate.of(2017, 1, 1))
        println(ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(data))
    }

    @Test
    fun createDailyStartEndHistory() {
        val dailyStartEndList = listOf(Api0002Request.Day().apply {
            bizDate = "2017-03-15"
            startDatetime = "2017-03-15T12:34:56+09:00"
        })
        apiService.createDailyStartEndHistory(HimawariUser(1, "kougami", "", listOf()), Api0002Request().apply { days = dailyStartEndList })
    }

}