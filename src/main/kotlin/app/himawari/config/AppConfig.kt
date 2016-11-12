package app.himawari.config

/**
 * Created by masahiro on 2016/11/12.
 */
class AppConfig {
    val mockSetting: MockSetting = MockSetting("")


    /**
     * @property responseDelay title
     */
    data class MockSetting(
            var responseDelay: String = ""
    )
}