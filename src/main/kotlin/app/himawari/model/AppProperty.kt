package app.himawari.model

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * アプリプロパティを扱うクラスです。
 * Created by cxpqwvtj on 2017/04/07.
 */
@Component
@ConfigurationProperties(prefix = "app")
class AppProperty {
    var datetime: DateTime = DateTime()

    class DateTime {
        var timezone: String = "Asia/Tokyo"
        var bizDate: String = ""
    }

    var log: Log = Log()

    class Log {
        var filter: Filter = Filter()

        class Filter {
            var type: String = "SIMPLE"
        }
    }

    var timecard: TimeCard = TimeCard()

    class TimeCard {
        var excel: Excel = Excel()

        class Excel {
            val templateFilePath: String = "./template/timecard.xlsx"
            val downloadFileName: String = "timecard.xlsx"
            val outputSheetName: String = "timecard"
            val beginRowNum: Int = 1
            val bizDateColumnIndex: Int = 1
            val startDatetimeColumnIndex: Int = 2
            val endDatetimeColumnIndex: Int = 3
            val vacationTypeColumnIndex: Int = 4
            val noteColumnIndex: Int = 5
            val autoSizeColumnIndexes: List<Int> = listOf(1, 2, 3, 4, 5)
        }
    }
}