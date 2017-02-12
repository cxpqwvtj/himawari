package app.himawari.service.api

import app.himawari.dto.json.StartEndDatetimes
import app.himawari.model.HimawariUser
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
        apiService.selectMonthlyInOutData("kougami", LocalDate.now())
    }

    @Test
    fun createDailyStartEndHistory() {
        apiService.createDailyStartEndHistory(HimawariUser(1, "kougami", "", listOf()), StartEndDatetimes().apply { days = listOf() })
    }

}