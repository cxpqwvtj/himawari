package app.himawari.controller.api.v1

import app.himawari.dto.json.Api0002Request
import app.himawari.dto.json.Api0002Response
import app.himawari.dto.json.Api1001Response
import app.himawari.model.HimawariUser
import app.himawari.service.api.ApiService
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.security.core.annotation.AuthenticationPrincipal
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
class ApiController(
        val service: ApiService
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping(path = arrayOf("/**"), method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    fun root(request: HttpServletRequest) {
        logger.debug(request.requestURL.toString())
    }

    @GetMapping(path = arrayOf("/timecards/{year_month}"))
    fun userTimecard(@AuthenticationPrincipal user: HimawariUser, @PathVariable("year_month") yearMonth: String): Api1001Response {
        val pattern = DateTimeFormatter.ofPattern("yyyyMMdd")
        val localDate = LocalDate.parse("${yearMonth}01", pattern)
        return service.selectMonthlyInOutData(user.username, localDate)
    }

    @GetMapping(path = arrayOf("/users/{user_id}/timecards/{year_month}"))
    fun adminTimecard(@PathVariable("user_id") userId: String, @PathVariable("year_month") yearMonth: String): Api1001Response {
        val pattern = DateTimeFormatter.ofPattern("yyyyMMdd")
        val localDate = LocalDate.parse("${yearMonth}01", pattern)
        return service.selectMonthlyInOutData(userId, localDate)
    }

    @PostMapping(path = arrayOf("/user/days"), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createStartEnd(@AuthenticationPrincipal user: HimawariUser, @RequestBody startEndDatetimes: Api0002Request): Api0002Response {
        return service.createDailyStartEndHistory(user, startEndDatetimes)
    }
}