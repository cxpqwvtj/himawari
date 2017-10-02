package app.himawari.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by cxpqwvtj on 2017/10/02.
 */
@Component
@ConfigurationProperties(prefix = "app")
class AppConfig(
        var datetime: Datetime = Datetime(),
        var security: Security = Security()
) {
    class Datetime(
            var timezone: String = "Asia/Tokyo",
            var bizDate: String = ""
    )

    class Security(
            var enabled: Boolean = true
    )
}