package app.himawari.service.api

import app.himawari.dto.json.gen.TimeCardResponse
import app.himawari.exbhv.DailyStartEndBhv
import app.himawari.exbhv.TimecardDayBhv
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * APIサービスクラスです。
 * Created by masahiro on 2017/01/15.
 */
@Service
class ApiService(
        private val dailyStartEndBhv: DailyStartEndBhv
) {
    fun selectMonthlyInOutData(userId: String, yearMonth: LocalDate): TimeCardResponse {
        val list = TimecardDayBhv().selectList { cb ->
            cb.setupSelect_DailyStartEndAsCurrentValue()
            cb.query().setBizDate_FromTo(yearMonth, yearMonth, { option -> option.compareAsMonth() })
            cb.query().queryMember().setMemberAccountId_Equal(userId)
        }
        return TimeCardResponse().apply {
            result = TimeCardResponse.Result().apply {
                this.yearMonth = yearMonth.format(DateTimeFormatter.ofPattern("yyyyMM"))
                days = list.map { day ->
                    TimeCardResponse.Result.Days().apply {
                        bizDate = day.bizDate.format(DateTimeFormatter.ISO_DATE)
                        day.dailyStartEndAsCurrentValue.alwaysPresent { startDate = it.startDatetime.format(DateTimeFormatter.ISO_DATE_TIME) }
                        day.dailyStartEndAsCurrentValue.alwaysPresent { endDate = it.endDatetime.format(DateTimeFormatter.ISO_DATE_TIME) }
                        day.dailyStartEndAsCurrentValue.alwaysPresent { remarks = it.note }
                    }
                }
            }
        }
    }
}