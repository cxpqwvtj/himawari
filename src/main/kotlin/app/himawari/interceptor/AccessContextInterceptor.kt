package app.himawari.interceptor

import app.himawari.model.AppDate
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.dbflute.hook.AccessContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component


/**
 * DBFluteのアクセスコンテキストを設定するためのインターセプタクラスです。
 * Created by cxpqwvtj on 2017/02/11.
 */
@Component
@Aspect
class AccessContextInterceptor(
        private val appDate: AppDate
) {

    @Around("execution(* app.himawari.controller..*.*(..))")
    fun around(point: ProceedingJoinPoint): Any {
        if (AccessContext.isExistAccessContextOnThread()) {
            // 既に設定されていたら何もしないで次へ
            // (二度呼び出しされたときのために念のため)
            return point.proceed()
        }

        // [アクセスユーザ]
        // 例えば、セッション上のログインユーザを利用。
        // ログインしていない場合のことも考慮すること。
        val authentication = SecurityContextHolder.getContext().authentication
        val accessUser = if (authentication == null) {
            "anonymous"
        } else {
            val principal = authentication.principal
            if (principal is UserDetails) {
                principal.username
            } else {
                principal.toString()
            }
        }

        val context = AccessContext()
        context.accessLocalDateTime = appDate.systemDate().toLocalDateTime()
        context.accessUser = accessUser
        AccessContext.setAccessContextOnThread(context)

        try {
            return point.proceed()
        } finally {
            // 最後はしっかりクリアすること (必須)
            AccessContext.clearAccessContextOnThread()
        }
    }
}