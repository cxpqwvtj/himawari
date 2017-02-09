package app.himawari.service.auth

import app.himawari.exbhv.MemberRoleBhv
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

/**
 * ユーザー情報取得サービスクラスです。
 * Created by cxpqwvtj on 2017/02/08.
 */
@Component
class UserDetailsServiceImpl(
        val memberRoleBhv: MemberRoleBhv
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val entities = memberRoleBhv.selectList { cb ->
            cb.setupSelect_Member()
            cb.query().queryMember().setMemberAccountId_Equal(username)
        }
        if (entities.size == 0) {
            throw UsernameNotFoundException("User not found.")
        }

        return User(entities[0].member.get().memberAccountId, entities[0].member.get().password, entities.map { SimpleGrantedAuthority(it.roleTypeCode) })
    }
}