package app.himawari.config

import app.himawari.model.auth.DevUserHandlerMethodArgumentResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Created by cxpqwvtj on 2018/03/18.
 */
@Configuration
class WebMvcConfig(
        private val appConfig: AppConfig
) : WebMvcConfigurer {
    override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
        super.addArgumentResolvers(resolvers)
        if (!appConfig.security.enabled) {
            resolvers.add(DevUserHandlerMethodArgumentResolver())
        }
    }
}