const fs = require('fs')
const Excel = require('exceljs')
const Immutable = require('immutable')
const DefaultConfig = require('./config.js')

const workbook = new Excel.Workbook()

const cellValue = (cell) => {
  if (cell.type === Excel.ValueType.Formula) {
    return cell.value.result
  }
  return cell.value
}

const directoryExists = (filePath) => {
  try {
    return fs.statSync(filePath).isDirectory()
  } catch (err) {
    return false
  }
}

const fileExists = (filePath) => {
  try {
    return fs.statSync(filePath).isFile()
  } catch (err) {
    return false
  }
}

const customConfigFilePath = './buildSrc/src/main/javascript/customConfig.json'
const config = (fileExists(customConfigFilePath)) ? Immutable.fromJS(DefaultConfig).mergeDeep(Immutable.fromJS(JSON.parse(fs.readFileSync(customConfigFilePath).toString()))).toJS() : DefaultConfig
if (!directoryExists(config.jsonDefXlsxDir)) {
  console.log(`ディレクトリが存在しません。${config.jsonDefXlsxDir}`) // eslint-disable-line no-console
  return
}
fs.readdir(config.jsonDefXlsxDir, (err, files) => {
  if (err) {
    console.log('ファイル検索でエラーが発生しました。', JSON.stringify(err, null, 2)) // eslint-disable-line no-console
    return
  }
  files.map((file) => {
    if (file.endsWith('.xlsx')) {
      console.log(`${config.jsonDefXlsxDir}/${file}`)
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
