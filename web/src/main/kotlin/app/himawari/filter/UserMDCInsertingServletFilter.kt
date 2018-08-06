package app.himawari.filter

import org.slf4j.MDC
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import javax.servlet.*

/**
 * Created by cxpqwvtj on 2018/07/29.
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 1)
class UserMDCInsertingServletFilter : Filter {

    companion object {
        private const val USER_KEY = "username"
    }

    override fun init(filterConfig: FilterConfig?) {
        // NOP
    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain) {
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

        MDC.put(USER_KEY, accessUser)

        try {
            chain.doFilter(request, response)
        } finally {
            MDC.remove(USER_KEY)
        }
    }

    override fun destroy() {
        // NOP
    }
}