package app.himawari.gen.meta
/**
 * data class 生成用クラス
 * Created by masahiro on 2016/11/13.
 */
class DataClassMeta {
    /** 変数名 */
    String name
    /** 説明 */
    String description = ""
    /** 型 */
    String typeDef
    /** array用 */
    DataClassMeta items
    /** object用 */
    List<DataClassMeta> properties
    /** デフォルト値 */
    String defaultValue

    DataClassMeta(def entry) {
        try {
            this.name = entry.key
            this.description = entry.value.title
            if (!JsonType.values().any { it.definitions.contains(entry.value.type) }) {
                println "規定外の定義です。[name]${entry.key}, [type]${entry.value.type}"
            }
            this.typeDef = entry.value.type
            if (this.getType() == JsonType.ARRAY) {
                items = new DataClassMeta(["${entry.key}": entry.value.items].entrySet().first())
            } else if (this.getType() == JsonType.OBJECT) {
                this.properties = entry.value.properties.collect { new DataClassMeta(it) }
            }
        } catch (Exception e) {
            println "${entry.key}でエラー発生"
            throw e
        }
    }

    String getClassName() {
        if (getType() == JsonType.OBJECT) {
            return name[0].toUpperCase() + name[1..<name.size()]
        }
        return getType().kotlinType
    }

    JsonType getType() {
        JsonType.values().find { it.definitions.contains(typeDef) }
    }

    String getPropertiyClassDef() {
        if (getType() == JsonType.OBJECT) {
            return "${getClassName()} = ${getClassName()}()"
        } else if (getType() == JsonType.ARRAY) {
            return "${String.format(JsonType.ARRAY.kotlinType, items.getClassName())} = listOf()"
        } else {
            return "${getType().kotlinType} = ${defaultValue}"
        }
    }

    String generateClass() {
        def propDescriptions = properties.collect { " * @property ${it.name} ${it.description}" }
        def props = properties.collect { "     var ${it.name}: ${it.getPropertiyClassDef()}" }
        return """/**
 * ${description}
 *
${propDescriptions.join("\n")}
 */
data class ${getClassName()} (
${props.join("\n")}
)
"""
    }
}
