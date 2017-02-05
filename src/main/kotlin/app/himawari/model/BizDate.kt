package app.himawari.model

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * アプリの現在日付を扱うクラスです
 * Created by cxpqwvtj on 2017/02/05.
 */
@Component
class BizDate(
        @Value("\${app.datetime.timezone}") private val timeZone: String,
        @Value("\${app.datetime.bizDate}") private val bizDate: String
) {
    val FORMAT_ISO_OFFSET_DATE_TIME_FIXED_FRACTION = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")

    fun now(): ZonedDateTime {
        if (bizDate == "") {
            return ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(timeZone))
        }
        return ZonedDateTime.parse(bizDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
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