const fs = require('fs')
const Excel = require('exceljs')

const Utils = require('./utils')
const config = require('./config.js')

const workbook = new Excel.Workbook()

const cellValue = (cell) => {
  if (cell.type === Excel.ValueType.Formula) {
    //return cell.value.result
  } else if (cell.type === Excel.ValueType.RichText) {
    console.log(JSON.stringify(cell.value, null, 2))
  }
  return cell.toString().replace(/\r\n/g, '\\n')
}

if (!Utils.existsDirectory(config.jsonDefXlsxDir)) {
  console.log(`ディレクトリが存在しません。${config.jsonDefXlsxDir}`) // eslint-disable-line no-console
  return
}
fs.readdir(config.jsonDefXlsxDir, (err, files) => {
  if (err) {
    console.log('ファイル検索でエラーが発生しました。', JSON.stringify(err, null, 2)) // eslint-disable-line no-console
    return
  }
  files.map((file) => {
    if (!file.startsWith('~$') && file.endsWith('.xlsx')) {
      console.log(`${config.jsonDefXlsxDir}/${file} ...`) // eslint-disable-line no-console
      workbook.xlsx.readFile(`${config.jsonDefXlsxDir}/${file}`).then(() => {
        workbook.eachSheet((worksheet, sheetId) => {
          console.log(`[WorksheetName]${worksheet.name}`)
          worksheet.eachRow((row, rowNumber) => {
            const cells = []
            row.eachCell((cell, colNumber) => {
              cells.push(cellValue(cell))
            })
            console.log(`${rowNumber}: ${cells.join(', ')}`)
          })
        })
      })
    }
  })
})
