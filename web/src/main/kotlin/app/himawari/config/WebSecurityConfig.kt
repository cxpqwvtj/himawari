package app.himawari.config

import app.himawari.service.auth.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


/**
 * SpringSecurity用のJavaConfigクラスです。
 * Created by masahiro on 2016/11/12.
 */
@Configuration
@EnableWebSecurity
open class WebSecurityConfig(
        private val userDetailsService: UserDetailsServiceImpl
) {

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER - 1)
    open class ApiWebSecurityConfigurationAdapter(
            private val appConfig: AppConfig
    ) : WebSecurityConfigurerAdapter() {
        @Throws(Exception::class)
        override fun configure(http: HttpSecurity) {
            // @formatter:off
            http.antMatcher("/api/**")
                .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")
            // @formatter:on
            if (!appConfig.security.enabled) {
                http.csrf().disable()
            }
        }
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    open class FormLoginWebSecurityConfigurerAdapter(
            private val appConfig: AppConfig
    ) : WebSecurityConfigurerAdapter() {
        override fun configure(httpSecurity: HttpSecurity) {
            http.authorizeRequests().anyRequest().authenticated()
                    .and().formLogin()//.loginPage("/login").permitAll()
                    .and().logout().permitAll()
            http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            if (!appConfig.security.enabled) {
                http.csrf().disable()
            }
        }
    }
}