package app.himawari.config

import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * SpringSecurity用のJavaConfigクラスです。
 * Created by masahiro on 2016/11/12.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
open class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    @Override
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/assets/**")
    }

    @Override
    override fun configure(httpSecurity: HttpSecurity) {
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin()//.loginPage("/login").permitAll()
                .and().logout().permitAll()
    }

    @Override
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN", "USER")
                .and().withUser("user").password("user").roles("USER")
    }
}