package app.himawari.gen

/**
 * Created by masahiro on 2016/10/18.
 */
class MetaClass {
    String levelDef
    String logicalNameDef
    String descriptionDef
    String sizeDef
    String emptyConditionDef
    String variableNameDef
    String jsonTypeDef
    String noteDef
    List<MetaClass> properties

    void setVariableNameDef(variableNameDef) {
        if (variableNameDef ==~ /[A-Z].+/) {
            println("大文字開始の名称です。${variableNameDef}")
        }
        this.variableNameDef = variableNameDef
    }

    String getClassName() {
        return variableNameDef[0].toUpperCase() + variableNameDef[1..<variableNameDef.size()]
    }

    String getPropertyClassName() {
        if (isListProperty()) {
            return "List<${className}>"
        } else if (JsonType.OBJECT.definitions.contains(jsonTypeDef)) {
            return getClassName()
        } else if (JsonType.STRING.definitions.contains(jsonTypeDef)) {
            return "String"
        } else if (JsonType.NUMBER.definitions.contains(jsonTypeDef)) {
            return "Int"
        } else if (JsonType.BOOLEAN.definitions.contains(jsonTypeDef)) {
            return "Boolean"
        }
        println("想定外の型です。varialbleName:${variableNameDef}")
        return ""
    }

    Boolean isListProperty() {
        if (sizeDef ==~ /0-1/) {
            return false
        }
        if (sizeDef.contains("n") || sizeDef.contains("-")) {
            return true
        }
        return false
    }
}
