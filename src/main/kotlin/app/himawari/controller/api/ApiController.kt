package app.himawari.controller.api

import app.himawari.dto.json.gen.TimeCardResponse
import app.himawari.service.api.ApiService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
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

    @RequestMapping(path = arrayOf("/users/{user_id}/timecards/{year_month}"), method = arrayOf(RequestMethod.GET))
    open fun timecard(@PathVariable("user_id") userId: String, @PathVariable("year_month") yearMonth: String): TimeCardResponse {
        return service.selectMonthlyInOutData(userId, yearMonth)
    }
}