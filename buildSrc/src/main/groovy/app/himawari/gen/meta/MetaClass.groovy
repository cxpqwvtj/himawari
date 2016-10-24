package app.himawari.gen.meta

import app.himawari.gen.excel.Util
import org.apache.poi.ss.usermodel.Row

/**
 * Created by masahiro on 2016/10/18.
 */
class MetaClass {
    Row row
    String levelDef
    String logicalNameDef
    String descriptionDef
    String sizeDef
    String emptyConditionDef
    String variableNameDef
    String jsonTypeDef
    String noteDef
    MetaClass parent = null
    List<MetaClass> properties = []

    /**
     * ルートオブジェクトの場合、このコンストラクタを使用する。
     */
    MetaClass(String name, String variableName) {
        logicalNameDef = name
        variableNameDef = variableName
        jsonTypeDef = "オブジェクト"
    }

    MetaClass(Row row) {
        assert row != null
        this.row = row
        if (row.lastCellNum < 8) return
        levelDef = Util.stringValue(row.getCell(1)).trim()
        logicalNameDef = Util.stringValue(row.getCell(2))
        descriptionDef = Util.stringValue(row.getCell(3))
        sizeDef = Util.stringValue(row.getCell(4))
        emptyConditionDef = Util.stringValue(row.getCell(5))
        variableNameDef = Util.stringValue(row.getCell(6))
        jsonTypeDef = Util.stringValue(row.getCell(7))
        noteDef = Util.stringValue(row.getCell(8))
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

    int getLevel() {
        return Integer.parseInt(levelDef.trim())
    }

    boolean validate() {
        def ret = true
        def rowNum = row.getRowNum() + 1
        if (levelDef ==~ /[0-9]+/) {
            // 正常
        } else {
            println("[${rowNum}]levelが不正です")
            ret = false
        }
        if (variableNameDef ==~ /[A-Z].+/) {
            println("[${rowNum}]大文字開始の名称です。${variableNameDef}")
            ret = false
        }
        return ret
    }
}
