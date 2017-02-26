package app.himawari

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.core.convert.ConversionService
import org.springframework.format.support.DefaultFormattingConversionService

/**
 * アプリケーションエントリーポイント
 * Created by masahiro on 2016/010/02.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
open class Application {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

    @Bean
    open fun conversionService(): ConversionService {
        return DefaultFormattingConversionService()
    }
}
