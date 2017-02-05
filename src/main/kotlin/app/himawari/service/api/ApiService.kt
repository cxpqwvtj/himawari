package app.himawari.service.api

import app.himawari.dto.json.Timecard
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
    fun selectMonthlyInOutData(userId: String, yearMonth: LocalDate): Timecard {
        val list = timecardDayBhv.selectList { cb ->
            cb.setupSelect_DailyStartEndAsCurrentValue()
            cb.query().setBizDate_FromTo(yearMonth, yearMonth, { option -> option.compareAsMonth() })
            cb.query().queryMember().setMemberAccountId_Equal(userId)
            cb.query().addOrderBy_BizDate_Asc()
        }
        return Timecard().apply {
            this.yearMonth = yearMonth.format(DateTimeFormatter.ofPattern("yyyyMM"))
            days = list.map { day ->
                Timecard.Days().apply {
                    bizDate = day.bizDate.format(DateTimeFormatter.ISO_DATE)
                    day.dailyStartEndAsCurrentValue.ifPresent {
                        startDatetime = appDate.toZonedDateTime(it.startDatetime)?.format(appDate.FORMAT_ISO_OFFSET_DATE_TIME_FIXED_FRACTION)
                    }
                    day.dailyStartEndAsCurrentValue.ifPresent {
                        endDatetime = appDate.toZonedDateTime(it.endDatetime)?.format(appDate.FORMAT_ISO_OFFSET_DATE_TIME_FIXED_FRACTION)
                    }
                    day.dailyStartEndAsCurrentValue.ifPresent { remarks = it.note }
                }
            }
        }
    }
}