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

    DataClassMeta(def hash) {
        this.name = hash.name
        this.description = hash.title
        if (!JsonType.values().any { it.definitions.contains(hash.type) }) {
            println "規定外の定義です。[name]${hash.name}, [type]${hash.type}"
        }
        this.typeDef = hash.type
        if (this.getType() == JsonType.ARRAY) {
            if (JsonType.OBJECT.definitions.contains(hash.items.type)) {
                items = new DataClassMeta(hash.items.properties.first())
            } else {
                items = new DataClassMeta(hash.items)
            }
        } else if (this.getType() == JsonType.OBJECT) {
            this.properties = hash.properties.collect { new DataClassMeta(it) }
        }
    }

    String getClassName() {
        return name[0].toUpperCase() + name[1..<name.size()]
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
        def props = properties.collect { "        var ${it.name}: ${it.getPropertiyClassDef()}" }
        def propDescriptions = properties.collect { " * @property ${it.name} ${it.description}" }
        """/**
${propDescriptions.join("\n")}
 */
data class ${getClassName()} (
${props.join("\n")}
)
"""
    }
}
