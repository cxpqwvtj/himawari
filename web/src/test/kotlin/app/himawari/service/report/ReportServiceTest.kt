package app.himawari.service.report

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate
import java.time.Month

/**
 * ReportServiceのテストクラスです。
 * Created by cxpqwvtj on 2017/02/26.
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ReportServiceTest {
    @Autowired
    lateinit var service: ReportService

    @Test
    fun createXlsx() {
        val xlsx = service.createXlsx(LocalDate.of(2017, Month.JANUARY, 1), "kougami")
        assertThat(xlsx).isNotNull
    }
}