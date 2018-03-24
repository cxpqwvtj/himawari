package app.himawari.config

import app.himawari.service.auth.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


/**
 * SpringSecurity用のJavaConfigクラスです。
 * Created by cxpqwvtj on 2016/11/12.
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig(
        private val appConfig: AppConfig,
        private val userDetailsService: UserDetailsServiceImpl
) : WebSecurityConfigurerAdapter() {

    override fun configure(web: WebSecurity) {
        // @formatter:off
        web
            .ignoring()
                .mvcMatchers("/assets/**")
                .mvcMatchers("/version")
        // @formatter:on
    }

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun configure(http: HttpSecurity) {
        if (appConfig.security.enabled) {
            // @formatter:off
            http
                .authorizeRequests()
                    .mvcMatchers("/api/**")
                    .hasRole("USER")
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and()
                    .csrf()
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            // @formatter:on
        } else {
            http.authorizeRequests().anyRequest().permitAll()
            http.csrf().disable()
        }
    }
}
