package app.himawari.service.api

import app.himawari.dto.json.gen.TimeCardResponse
import app.himawari.exbhv.DailyInOutBhv
import org.springframework.stereotype.Service
import java.time.format.DateTimeFormatter

/**
 * APIサービスクラスです。
 * Created by masahiro on 2017/01/15.
 */
@Service
class ApiService(
        private val dailyInOutBhv: DailyInOutBhv
) {
    fun selectMonthlyInOutData(userId: String, yearMonth: String): TimeCardResponse {
        val list = dailyInOutBhv.selectList {
            it.setupSelect_Timecard()
            it.query().queryTimecard().setTimecardYearMonth_Equal(yearMonth)
            it.query().queryTimecard().queryMember().setMemberAccountId_Equal(userId)
        }
        return TimeCardResponse().apply {
            result = TimeCardResponse.Result().apply {
                this.yearMonth = yearMonth
                days = list.map { day ->
                    TimeCardResponse.Result.Days().apply {
                        bizDate = day.bizDate.format(DateTimeFormatter.ISO_DATE)
                        startDate = day.startDatetime.format(DateTimeFormatter.ISO_DATE_TIME)
                        endDate = day.finishDatetime.format(DateTimeFormatter.ISO_DATE_TIME)
                        remarks = day.note
                    }
                }
            }
        }
    }
}