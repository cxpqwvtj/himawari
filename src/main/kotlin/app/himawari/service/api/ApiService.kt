package app.himawari.service.api

import app.himawari.dto.json.gen.TimeCardResponse
import app.himawari.exbhv.TimecardDayBhv
import app.himawari.model.BizDate
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * APIサービスクラスです。
 * Created by masahiro on 2017/01/15.
 */
@Service
class ApiService(
        private val appDate: BizDate,
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
                            startDate = appDate.toZonedDateTime(it.startDatetime)?.format(appDate.FORMAT_ISO_OFFSET_DATE_TIME_FIXED_FRACTION)
                        }
                        day.dailyStartEndAsCurrentValue.ifPresent {
                            endDate = appDate.toZonedDateTime(it.endDatetime)?.format(appDate.FORMAT_ISO_OFFSET_DATE_TIME_FIXED_FRACTION)
                        }
                        day.dailyStartEndAsCurrentValue.ifPresent { remarks = it.note }
                    }
                }
            }
        }
    }
}