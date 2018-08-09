package app.himawari.filter

import net.logstash.logback.argument.StructuredArguments.keyValue
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by cxpqwvtj on 2018/07/29.
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 1)
class AppMetricsFilter : OncePerRequestFilter() {
    private val log = LoggerFactory.getLogger(this.javaClass)

    companion object {
        private const val APP_BEGIN_TIME = "app_begin_time"
        private const val REMOTE_HOST = "remote_host"
        private const val REMOTE_USER = "remote_user"
        private const val REQUESTED_URI = "requested_uri"
        private const val REQUESTED_URL = "requested_url"
        private const val METHOD = "method"
        private const val QUERY_STRING = "query_string"
        private const val USER_AGENT = "user_agent"
        private const val X_FORWARDED_FOR = "x_forwarded_for"
    }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse?, filterChain: FilterChain) {
        val authentication = SecurityContextHolder.getContext().authentication
        val accessUser = if (authentication == null) {
            "anonymous"
        } else {
            val principal = authentication.principal
            if (principal is UserDetails) {
                principal.username
            } else {
                principal.toString()
            }
        }

        MDC.put(REMOTE_HOST, request.remoteHost)
        MDC.put(REMOTE_USER, accessUser)
        MDC.put(REQUESTED_URI, request.requestURI)
        val requestURL = request.requestURL
        if (requestURL != null) {
            MDC.put(REQUESTED_URL, requestURL.toString())
        }
        MDC.put(METHOD, request.method)
        MDC.put(QUERY_STRING, request.queryString)
        MDC.put(USER_AGENT, request.getHeader("User-Agent"))
        MDC.put(X_FORWARDED_FOR, request.getHeader("X-Forwarded-For"))
        request.setAttribute(APP_BEGIN_TIME, System.nanoTime())

        try {
            filterChain.doFilter(request, response)
        } finally {
            val beginTime = request.getAttribute(APP_BEGIN_TIME)
            if (beginTime is Long) {
                val elapsedTime = (System.nanoTime() - beginTime) / (1000 * 1000)
                log.info("{} ms", keyValue("elapsed_time", elapsedTime))
            }
            MDC.remove(REMOTE_HOST)
            MDC.remove(REMOTE_USER)
            MDC.remove(REQUESTED_URI)
            MDC.remove(REQUESTED_URL)
            MDC.remove(METHOD)
            MDC.remove(QUERY_STRING)
            MDC.remove(USER_AGENT)
            MDC.remove(X_FORWARDED_FOR)
            MDC.remove(APP_BEGIN_TIME)
        }
    }
}