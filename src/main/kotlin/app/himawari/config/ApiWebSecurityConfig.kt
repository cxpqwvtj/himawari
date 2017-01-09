package app.himawari.config

import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * APIアクセスのセキュリティ設定クラスです。
 * Created by masahiro on 2017/01/09.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER - 2)
open class ApiWebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(httpSecurity: HttpSecurity) {
        http.authorizeRequests().anyRequest().authenticated()
                .and().antMatcher("/api/**")
                .exceptionHandling().authenticationEntryPoint(Http401AuthenticationEntryPoint(""))//.loginPage("/login").permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN", "USER")
                .and().withUser("user").password("user").roles("USER")
    }
}