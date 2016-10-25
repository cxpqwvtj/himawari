package app.himawari.gen.excel

import app.himawari.gen.meta.ApiDefinition
import app.himawari.gen.meta.MetaClass

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
            def apiIdentifier = Util.stringValue(sheet.getRow(0).getCell(1))
            def apiName = Util.stringValue(sheet.getRow(0).getCell(3))
            def apiDescription = "${apiIdentifier} ${apiName}"
            def apiDefinition = new ApiDefinition("", apiIdentifier, apiName, apiDescription)
            def headerRow = sheet.getRow(4)
            apiDefinition.headers = [Util.stringValue(headerRow.getCell(1)),
                                     Util.stringValue(headerRow.getCell(2)),
                                     Util.stringValue(headerRow.getCell(3)),
                                     Util.stringValue(headerRow.getCell(4)),
                                     Util.stringValue(headerRow.getCell(5)),
                                     Util.stringValue(headerRow.getCell(6)),
                                     Util.stringValue(headerRow.getCell(7)),
                                     Util.stringValue(headerRow.getCell(8))]
            MetaClass prevRow = null
            MetaClass parent = null
            boolean defStarted = false
            (sheet.firstRowNum..sheet.lastRowNum).each { rowNum ->
                def row = sheet.getRow(rowNum)
                try {
                    if (row == null) return
                    if (Util.stringValue(row.getCell(0)) == "request") defStarted = true
                    if (!defStarted) return
                    def meta = new MetaClass(row)
                    if (!meta.validate()) return
                    if (meta.level <= 1) {
                        parent = meta
                    } else if (prevRow.level == meta.level) {
                        meta.parent = parent
                        parent.properties.add(meta)
                    } else if (prevRow.level == meta.level + 1) {
                        parent = prevRow
                        meta.parent = parent
                        parent.properties.add(meta)
                    } else if (prevRow.level > meta.level) {
                        def temp = parent
                        while (temp != null) {
                            if (temp.level == meta.level + 1) {
                                parent = temp
                                break;
                            }
                            temp = parent.parent
                        }
                        meta.parent = parent
                        parent.properties.add(meta)
                    }
                    if (Util.stringValue(row.getCell(0)) == "response") responseType = true
                    // TODO: トップレベルのプロパティにすべてのオブジェクトを詰めているのはバグ。階層構造を持つようにする
                    // TODO: HTML出力では階層構造を意識してtableを組み立てる
                    if (responseType) {
                        apiDefinition.response.properties.add(meta)
                    } else {
                        apiDefinition.request.properties.add(meta)
                    }
                    prevRow = meta
                } catch (Exception e) {
                    throw new Exception("${row.getRowNum() + 1}行目でエラーが発生しました。", e)
                }
            }
            apiDefinitions.add(apiDefinition)
        }
        return apiDefinitions
    }
}
