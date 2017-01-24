package app.himawari.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


/**
 * SpringSecurity用のJavaConfigクラスです。
 * Created by masahiro on 2016/11/12.
 */
@Configuration
@EnableWebSecurity
open class WebSecurityConfig {

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN", "USER")
                .and().withUser("user").password("user").roles("USER")
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER - 1)
    open class ApiWebSecurityConfigurationAdapter : WebSecurityConfigurerAdapter() {
        @Throws(Exception::class)
        override fun configure(http: HttpSecurity) {
            http.antMatcher("/api/**").authorizeRequests().anyRequest().hasRole("USER")
                    .and().httpBasic()
        }
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    open class FormLoginWebSecurityConfigurerAdapter : WebSecurityConfigurerAdapter() {
        override fun configure(httpSecurity: HttpSecurity) {
            http.authorizeRequests().anyRequest().authenticated()
                    .and().formLogin()//.loginPage("/login").permitAll()
                    .and().logout().permitAll()
            http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        }
    }
}