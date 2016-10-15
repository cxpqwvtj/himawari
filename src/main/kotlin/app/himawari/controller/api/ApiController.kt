package app.himawari.controller.api

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.servlet.http.HttpServletRequest

/**
 * Created by masahiro on 2016/10/15.
 */
@Controller
@RequestMapping("/api")
open class ApiController {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @RequestMapping(path = arrayOf("/**"), method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    open fun root(request: HttpServletRequest) {
        logger.debug(request.requestURL.toString())
    }
}