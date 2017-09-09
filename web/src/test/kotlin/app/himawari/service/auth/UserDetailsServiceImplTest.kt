package app.himawari.service.auth

import app.himawari.Application
import app.himawari.UnitHimawariContainerTestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.junit4.SpringRunner

/**
 * UserDetailsServiceImplのテストクラスです。
 * Created by cxpqwvtj on 2017/02/12.
 */
@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class), webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class UserDetailsServiceImplTest : UnitHimawariContainerTestCase() {
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder
    @Autowired
    lateinit var service: UserDetailsServiceImpl

    @Test
    fun loadUserByUsername() {
        val user = service.loadUserByUsername("kougami")
        assertThat(passwordEncoder.matches("kougami", user.password)).isTrue()
    }

}