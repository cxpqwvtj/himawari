// Code generated by Node.js script
package app.himawari.dto.json

import com.fasterxml.jackson.annotation.JsonInclude

/**
 * 日次情報登録パラメータ
 * @property id ユーザーID
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Api0003Request(
        var id: String? = null)
