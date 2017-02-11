package app.himawari.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

/**
 * システムのメンバー情報を扱うクラスです。
 * Created by cxpqwvtj on 2017/02/11.
 */
class HimawariUser(val memberId: Long,
                   username: String,
                   password: String,
                   authorities: Collection<GrantedAuthority>
) : User(username, password, authorities) {
}