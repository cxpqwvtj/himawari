package app.himawari.gen.excel

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
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

    static protected String stringValue(Cell cell) {
        if (cell == null) return ""
        if (cell.getCellTypeEnum() == CellType.STRING) {
            return cell.getStringCellValue()
        } else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue() ? "true" : "false"
        } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
            return new BigDecimal(cell.getNumericCellValue()).toPlainString()
        } else if (cell.getCellTypeEnum() == CellType.FORMULA) {
            return cell.getStringCellValue()
        }
        return ""
    }
}
