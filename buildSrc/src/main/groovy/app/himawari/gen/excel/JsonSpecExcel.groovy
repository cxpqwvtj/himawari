package app.himawari.gen.excel

import app.himawari.gen.ApiDefinition
import app.himawari.gen.MetaClass
import app.himawari.gen.excel.SpecExcel

/**
 * Created by masahiro on 2016/10/22.
 */
class JsonSpecExcel extends SpecExcel {

    JsonSpecExcel(File file) {
        super(file)
    }

    List<ApiDefinition> read() {
        println("read ${this.file.name} ...")
        def apiDefinitions = []
        (0..<book.getNumberOfSheets()).each { sheetIndex ->
            def sheet = book.getSheetAt(sheetIndex)
//            if (sheet.sheetName ==~ /.*/) return
            def responseType = false
            def apiDefinition = new ApiDefinition()
            apiDefinition.apiIdentifier = stringValue(sheet.getRow(0).getCell(1))
            apiDefinition.apiName = stringValue(sheet.getRow(0).getCell(3))
            apiDefinition.apiDescription = "${apiDefinition.apiIdentifier} ${apiDefinition.apiName}"
            (sheet.firstRowNum..sheet.lastRowNum).each { rowNum ->
                def row = sheet.getRow(rowNum)
                if (row == null || row.lastCellNum >= 8) return
                if (stringValue(row.getCell(0)) == "response") responseType = true
                def meta = new MetaClass(
                        levelDef: stringValue(row.getCell(1)),
                        logicalNameDef: stringValue(row.getCell(2)),
                        descriptionDef: stringValue(row.getCell(3)),
                        sizeDef: stringValue(row.getCell(4)),
                        emptyConditionDef: stringValue(row.getCell(5)),
                        variableNameDef: stringValue(row.getCell(6)),
                        jsonTypeDef: stringValue(row.getCell(7)),
                        noteDef: stringValue(row.getCell(8)))
                if (responseType) {
                    apiDefinition.response.properties.add(meta)
                } else {
                    apiDefinition.request.properties.add(meta)
                }
            }
            apiDefinitions.add(apiDefinition)
        }
        return apiDefinitions
    }
}
