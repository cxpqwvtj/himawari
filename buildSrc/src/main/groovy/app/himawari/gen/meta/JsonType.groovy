package app.himawari.gen.meta

/**
 * Created by masahiro on 2016/10/18.
 */
enum JsonType {
    OBJECT(["オブジェクト", "ｵﾌﾞｼﾞｪｸﾄ", "object"]),
    STRING(["文字列", "文字", "string"]),
    NUMBER(["数値", "数字", "number", "num"]),
    BOOLEAN(["ブーリアン", "ブール", "bool", "boolean"])

    List<String> definitions

    JsonType(List<String> definitions) {
        this.definitions = definitions
    }
}
