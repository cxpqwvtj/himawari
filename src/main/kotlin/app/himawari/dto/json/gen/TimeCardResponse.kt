// Code generated by node script
package app.himawari.dto.json.gen

/**
 * 月の時間データ取得APIレスポンス
 * @property result 結果
 * @property error エラー情報
 */
data class TimeCardResponse(
    var result: Result,
    var error: Error) {
  /**
   * 結果
   * @property yearMonth 年月(yyyyMM)
   * @property days 日次データ
   */
  data class Result(
      var yearMonth: String,
      var days: List<Days>) {
    /**
     * 日次データ
     * @property bizDate 業務日
     * @property startDate 開始時間
     * @property endDate 終了時間
     * @property remarks 備考
     */
    data class Days(
        var bizDate: String,
        var startDate: String,
        var endDate: String,
        var remarks: String)
  }
  /**
   * エラー情報
   * @property code エラーコード
   * @property message エラーメッセージ
   */
  data class Error(
      var code: String,
      var message: String)
}
