package app.himawari.gen.meta

/**
 * Created by masahiro on 2016/10/18.
 */
enum JsonType {
    OBJECT(["オブジェクト", "ｵﾌﾞｼﾞｪｸﾄ", "object"], "Any"),
    STRING(["文字列", "文字", "string"], "String"),
    NUMBER(["数値", "数字", "number", "num"], "Int"),
    BOOLEAN(["ブーリアン", "ブール", "bool", "boolean"], "Boolean"),
    ARRAY(["配列", "array"], "List<%s>")

    List<String> definitions
    String kotlinType

    JsonType(List<String> definitions, String kotlinType) {
        this.definitions = definitions
        this.kotlinType = kotlinType
    }
}
