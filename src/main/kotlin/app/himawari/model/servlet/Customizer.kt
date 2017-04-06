package app.himawari.model.servlet

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.web.servlet.ErrorPage
import org.springframework.http.HttpStatus

/**
 * サーブレットコンテナカスタムクラスです。
 * Created by cxpqwvtj on 2017/03/30.
 */
class Customizer : EmbeddedServletContainerCustomizer {
    override fun customize(container: ConfigurableEmbeddedServletContainer) {
        container.addErrorPages(ErrorPage(HttpStatus.NOT_FOUND, "/404"))
    }
}