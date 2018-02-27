package app.himawari.service.auth

import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

/**
 * Created by cxpqwvtj on 2017/11/03.
 */
//@Component
//@Profile("dev")
class FixedAuthenticatedProvider : AbstractUserDetailsAuthenticationProvider() {
    override fun retrieveUser(username: String?, authentication: UsernamePasswordAuthenticationToken?): UserDetails {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun additionalAuthenticationChecks(userDetails: UserDetails?, authentication: UsernamePasswordAuthenticationToken?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}