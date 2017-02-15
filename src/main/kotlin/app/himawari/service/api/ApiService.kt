package app.himawari.service.api

import app.himawari.dto.json.Api0001Response
import app.himawari.dto.json.Api0002Request
import app.himawari.dto.json.Api0002Response
import app.himawari.exbhv.DailyStartEndBhv
import app.himawari.exbhv.TimecardDayBhv
import app.himawari.exentity.DailyStartEnd
import app.himawari.exentity.TimecardDay
import app.himawari.model.AppDate
import app.himawari.model.HimawariUser
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * APIサービスクラスです。
 * Created by masahiro on 2017/01/15.
 */
@Service
class ApiService(
        private val appDate: AppDate,
        private val timecardDayBhv: TimecardDayBhv,
        private val dailyStartEndBhv: DailyStartEndBhv
) {
    fun selectMonthlyInOutData(userId: String, yearMonth: LocalDate): Api0001Response {
        val list = timecardDayBhv.selectList { cb ->
            cb.setupSelect_DailyStartEndAsCurrentValue()
            cb.query().setBizDate_FromTo(yearMonth, yearMonth, { option -> option.compareAsMonth() })
            cb.query().queryMember().setMemberAccountId_Equal(userId)
            cb.query().addOrderBy_BizDate_Asc()
        }
        return Api0001Response().apply {
            this.yearMonth = yearMonth.format(DateTimeFormatter.ofPattern("yyyyMM").withZone(appDate.zoneId()))
            days = list.map { day ->
                Api0001Response.Days().apply {
                    bizDate = day.bizDate.format(DateTimeFormatter.ISO_DATE.withZone(appDate.zoneId()))
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

    fun createDailyStartEndHistory(user: HimawariUser, requestParam: Api0002Request): Api0002Response {
        val entities = requestParam.days?.map { day ->
            val timecardDay = timecardDayBhv.selectEntity { cb ->
                cb.query().queryMember().setMemberAccountId_Equal(user.username)
                cb.query().setBizDate_Equal(LocalDate.parse(day.bizDate, DateTimeFormatter.ISO_DATE.withZone(appDate.zoneId())))
            }.orElseGet {
                val entity = TimecardDay().apply {
                    memberId = user.memberId
                    bizDate = LocalDate.parse(day.bizDate, DateTimeFormatter.ISO_DATE.withZone(appDate.zoneId()))
                }
                timecardDayBhv.insert(entity)
                entity
            }
            DailyStartEnd().apply {
                timecardDayId = timecardDay.timecardDayId
                startDatetime = appDate.toLocalDateTime(day.startDatetime ?: "")
                endDatetime = appDate.toLocalDateTime(day.endDatetime ?: "")
                note = day.note
            }
        }
        dailyStartEndBhv.batchInsert(entities)
        // TODO: 結果を設定する
        return Api0002Response().apply {
            resultType = Api0002Response.ResultType.success
        }
    }
}