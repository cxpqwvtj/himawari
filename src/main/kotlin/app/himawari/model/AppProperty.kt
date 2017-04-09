package app.himawari.model

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * アプリプロパティを扱うクラスです。
 * Created by cxpqwvtj on 2017/04/07.
 */
@Component
@ConfigurationProperties(prefix = "app")
class AppProperty {
}