package app.himawari.controller

import org.slf4j.LoggerFactory
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * 通常の(RESTではない)コントローラ
 * Created by masahiro on 2016/10/12.
 */
@Controller
@RequestMapping("/")
open class RootController {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping(path = arrayOf("", "timecards/**", "dev/**"), produces = arrayOf(MediaType.TEXT_HTML_VALUE))
    @ResponseBody
    open fun root(): Resource {
        return ClassPathResource("/static/index.html")
    }

    @GetMapping(path = arrayOf("xlsx"), produces = arrayOf("application/vnd.ms-excel"))
    open fun createTimecardXlsx(): ResponseEntity<Any> {
        val headers = HttpHeaders()
        val fileName = ""
        headers.set("Content-Disposition", "attachment; filename=${fileName}")
        // TODO:Excel生成
        val body = Any()
        return ResponseEntity(body, headers, HttpStatus.OK)
    }
}
