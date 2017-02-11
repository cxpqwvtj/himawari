package app.himawari.service.api

import app.himawari.dto.json.StartEndDatetimeUpdate
import app.himawari.dto.json.StartEndDatetimes
import app.himawari.dto.json.Timecard
import app.himawari.exbhv.DailyStartEndBhv
import app.himawari.exbhv.TimecardDayBhv
import app.himawari.exentity.DailyStartEnd
import app.himawari.exentity.TimecardDay
import app.himawari.model.BizDate
import app.himawari.model.HimawariUser
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * APIサービスクラスです。
 * Created by masahiro on 2017/01/15.
 */
@Service
class ApiService(
        private val appDate: BizDate,
        private val timecardDayBhv: TimecardDayBhv,
        private val dailyStartEndBhv: DailyStartEndBhv
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
                    day.dailyStartEndAsCurrentValue.ifPresent { note = it.note }
                }
            }
        }
    }

    fun createDailyStartEndHistory(user: HimawariUser, startEndDatetimes: StartEndDatetimes): StartEndDatetimeUpdate {
        val entities = startEndDatetimes.days?.map { day ->
            val timecardDay = timecardDayBhv.selectEntity { cb ->
                cb.query().queryMember().setMemberAccountId_Equal(user.username)
                cb.query().setBizDate_Equal(LocalDate.parse(day.bizDate, DateTimeFormatter.ISO_DATE))
            }.orElseGet {
                val entity = TimecardDay().apply {
                    memberId = user.memberId
                    bizDate = LocalDate.parse(day.bizDate, DateTimeFormatter.ISO_DATE)
                }
                timecardDayBhv.insert(entity)
                entity
            }
            DailyStartEnd().apply {
                timecardDayId = timecardDay.timecardDayId
                startDatetime = LocalDateTime.parse(day.startDatetime, appDate.FORMAT_ISO_OFFSET_DATE_TIME_FIXED_FRACTION)
                endDatetime = LocalDateTime.parse(day.endDatetime, appDate.FORMAT_ISO_OFFSET_DATE_TIME_FIXED_FRACTION)
                note = day.note
            }
        }
        dailyStartEndBhv.batchInsert(entities)
        // TODO: 結果を設定する
        return StartEndDatetimeUpdate()
    }
}