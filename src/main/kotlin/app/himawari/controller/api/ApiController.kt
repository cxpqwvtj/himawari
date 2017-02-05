package app.himawari.controller.api

import app.himawari.dto.json.Timecard
import app.himawari.service.api.ApiService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.servlet.http.HttpServletRequest

/**
 * APIリクエスト用コントローラ
 * Created by masahiro on 2016/10/15.
 */
@RestController
@RequestMapping("/api/v1")
open class ApiController(
        val service: ApiService
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping(path = arrayOf("/**"), method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    open fun root(request: HttpServletRequest) {
        logger.debug(request.requestURL.toString())
    }

    @GetMapping(path = arrayOf("/users/{user_id}/timecards/{year_month}"))
    open fun timecard(@PathVariable("user_id") userId: String, @PathVariable("year_month") yearMonth: String): Timecard {
        val pattern = DateTimeFormatter.ofPattern("yyyyMMdd")
        val localDate = LocalDate.parse("${yearMonth}01", pattern)
        return service.selectMonthlyInOutData(userId, localDate)
    }
}