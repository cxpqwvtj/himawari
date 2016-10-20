package app.himawari.gen

/**
 * Created by masahiro on 2016/10/18.
 */
class MetaClass {
    String variableName
    List<MetaClass> properties
    String jsonType
    String size

    void setVariableName(String value) {
        if (value ==~ /A-Z/) {
            println("大文字開始の名称です。${value}")
        }
    }

    String getClassName() {
        return variableName[0].toUpperCase() + variableName[1..<variableName.size()]
    }

    String getPropertyClassName() {
        if (isListProperty()) {
            return "List<${className}>"
        } else if (JsonType.OBJECT.definitions.contains(jsonType)) {
            return getClassName()
        } else if (JsonType.STRING.definitions.contains(jsonType)) {
            return "String"
        } else if (JsonType.NUMBER.definitions.contains(jsonType)) {
            return "Int"
        } else if (JsonType.BOOLEAN.definitions.contains(jsonType)) {
            return "Boolean"
        }
        println("想定外の型です。varialbleName:${variableName}")
        return ""
    }

    Boolean isListProperty() {
        if (size ==~ /0-1/) {
            return false
        }
        if (size.contains("n") || size.contains("-")) {
            return true
        }
        return false
    }
}
