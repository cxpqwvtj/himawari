package app.himawari.model.servletcontainer

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer

/**
 * サーブレットコンテナカスタムクラスです。
 * Created by cxpqwvtj on 2017/03/30.
 */
class Customizer : EmbeddedServletContainerCustomizer {
    override fun customize(container: ConfigurableEmbeddedServletContainer?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}