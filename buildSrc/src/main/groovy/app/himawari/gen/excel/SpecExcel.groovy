package app.himawari.gen.excel

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory

/**
 * Created by masahiro on 2016/10/22.
 */
class SpecExcel {
    protected File file
    protected Workbook book

    SpecExcel(File file) {
        this.file = file
        this.book = WorkbookFactory.create(file)
    }
}
