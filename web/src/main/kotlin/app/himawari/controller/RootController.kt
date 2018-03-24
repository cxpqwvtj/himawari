package app.himawari.controller

import app.himawari.model.AppProperty
import app.himawari.model.HimawariUser
import app.himawari.service.report.ReportService
import org.slf4j.LoggerFactory
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.servlet.http.HttpServletResponse

/**
 * 通常の(RESTではない)コントローラ
 * Created by masahiro on 2016/10/12.
 */
@Controller
@RequestMapping("/")
class RootController(
        private val reportService: ReportService,
        private val appProperty: AppProperty
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping(path = arrayOf("", "timecards/**", "dev/**"), produces = arrayOf(MediaType.TEXT_HTML_VALUE))
    @ResponseBody
    fun root(): Resource {
        return ClassPathResource("/static/index.html")
    }

    @GetMapping(path = arrayOf("excel/timecards/{yearMonth}"), produces = arrayOf("application/vnd.ms-excel"))
    fun createTimecardXlsx(@PathVariable yearMonth: String, @AuthenticationPrincipal user: HimawariUser, response: HttpServletResponse) {
        response.setHeader("Content-Disposition", "attachment; filename=${appProperty.timecard.excel.downloadFileName}")
        val localDate = LocalDate.parse("${yearMonth}01", DateTimeFormatter.ofPattern("yyyyMMdd"))
        reportService.createXlsx(localDate, user.username).write(response.outputStream)
    }

    @GetMapping(path = arrayOf("pdf/timecards/{yearMonth}"))
    fun createTimecardPdf(@PathVariable yearMonth: String, @AuthenticationPrincipal user: HimawariUser): ResponseEntity<ByteArray> {
        val httpHeaders = HttpHeaders()
        httpHeaders.contentType = MediaType.TEXT_HTML
        return ResponseEntity<ByteArray>(ClassPathResource("static/404.html").file.readBytes(), httpHeaders, HttpStatus.NOT_FOUND)
    }
}
