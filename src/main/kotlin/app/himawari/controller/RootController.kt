package app.himawari.controller

import app.himawari.service.report.ReportService
import org.slf4j.LoggerFactory
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
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
open class RootController(
        private val reportService: ReportService
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping(path = arrayOf("", "timecards/**", "dev/**"), produces = arrayOf(MediaType.TEXT_HTML_VALUE))
    @ResponseBody
    open fun root(): Resource {
        return ClassPathResource("/static/index.html")
    }

    @GetMapping(path = arrayOf("excel/timecards/{yearMonth}"), produces = arrayOf("application/vnd.ms-excel"))
    open fun createTimecardXlsx(@PathVariable yearMonth: String, response: HttpServletResponse) {
        val fileName = "timecard.xlsx"
        response.setHeader("Content-Disposition", "attachment; filename=${fileName}")
        val localDate = LocalDate.parse("${yearMonth}01", DateTimeFormatter.ofPattern("yyyyMMdd"))
        reportService.createXlsx(localDate, "kougami").write(response.outputStream)
    }
}
