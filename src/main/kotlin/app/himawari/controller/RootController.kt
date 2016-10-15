package app.himawari.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse

/**
 * Created by masahiro on 2016/10/12.
 */
@Controller
@RequestMapping("/")
open class RootController {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping(path = arrayOf("/"))
    open fun root(response: HttpServletResponse) {
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE)
        response.outputStream.use { it.write(this.javaClass.getResource("/static/index.html").readBytes()) }
    }
}
