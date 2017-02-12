package app.himawari.model

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * システムの日付を扱うクラスです
 * Created by cxpqwvtj on 2017/02/05.
 */
@Component
class AppDate(
        @Value("\${app.datetime.timezone}") private val timeZone: String,
        @Value("\${app.datetime.bizDate}") private val bizDate: String
) {
    val FORMAT_ISO_DATE_JST = DateTimeFormatter.ISO_LOCAL_DATE.withZone(ZoneId.of(timeZone))
    val FORMAT_ISO_OFFSET_DATE_TIME_FIXED_FRACTION = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")

    fun now(): ZonedDateTime {
        if (bizDate == "") {
            return ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(timeZone))
        }
        return ZonedDateTime.parse(bizDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }

    fun zoneId(): ZoneId {
        return ZoneId.of(timeZone)
    }

    fun toLocalDateTime(date: String): LocalDateTime? {
        if (date == "") {
            return null
        }
//        if (date.matches("[0-9]{4}-[01][0-9]-[0-3][0-9]".toRegex())){
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"))
//        }
    }

    fun toZonedDateTime(localDateTime: LocalDateTime?): ZonedDateTime? {
        if (localDateTime == null) {
            return null
        }
        return ZonedDateTime.of(localDateTime, ZoneId.of(timeZone))
    }

    fun systemDate(): ZonedDateTime {
        return ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(timeZone))
    }
}