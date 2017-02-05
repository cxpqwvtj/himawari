package app.himawari.service.api

import app.himawari.dto.json.gen.TimeCardResponse
import app.himawari.exbhv.TimecardDayBhv
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * APIサービスクラスです。
 * Created by masahiro on 2017/01/15.
 */
@Service
class ApiService(
        private val timecardDayBhv: TimecardDayBhv
) {
    fun selectMonthlyInOutData(userId: String, yearMonth: LocalDate): TimeCardResponse {
        val list = timecardDayBhv.selectList { cb ->
            cb.setupSelect_DailyStartEndAsCurrentValue()
            cb.query().setBizDate_FromTo(yearMonth, yearMonth, { option -> option.compareAsMonth() })
            cb.query().queryMember().setMemberAccountId_Equal(userId)
            cb.query().addOrderBy_BizDate_Asc()
        }
        return TimeCardResponse().apply {
            result = TimeCardResponse.Result().apply {
                this.yearMonth = yearMonth.format(DateTimeFormatter.ofPattern("yyyyMM"))
                days = list.map { day ->
                    TimeCardResponse.Result.Days().apply {
                        bizDate = day.bizDate.format(DateTimeFormatter.ISO_DATE)
                        day.dailyStartEndAsCurrentValue.ifPresent {
                            startDate = if (it.startDatetime == null) {
                                null
                            } else {
                                ZonedDateTime.of(it.startDatetime, ZoneId.of("JST", ZoneId.SHORT_IDS)).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                            }
                        }
                        day.dailyStartEndAsCurrentValue.ifPresent {
                            endDate = if (it.endDatetime == null) {
                                null
                            } else {
                                ZonedDateTime.of(it.endDatetime, ZoneId.of("JST", ZoneId.SHORT_IDS)).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                            }
                        }
                        day.dailyStartEndAsCurrentValue.ifPresent { remarks = it.note }
                    }
                }
            }
        }
    }
}