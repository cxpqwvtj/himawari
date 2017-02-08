package app.himawari.service.auth

import app.himawari.exbhv.MemberBhv
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

/**
 * ユーザー情報取得サービスクラスです。
 * Created by cxpqwvtj on 2017/02/08.
 */
@Component
class UserDetailsServiceImpl(
        val memberBhv: MemberBhv
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val entity = memberBhv.selectEntityWithDeletedCheck { cb ->
            cb.query().setMemberAccountId_Equal(username)
        }

        return User(entity.memberAccountId, entity.password, AuthorityUtils.createAuthorityList(entity.roleTypeCode))
    }
}