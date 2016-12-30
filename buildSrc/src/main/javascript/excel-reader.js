const fs = require('fs')
const Excel = require('exceljs')
const ejs = require('ejs')

const Utils = require('./utils')
const config = require('./config.js')

const workbook = new Excel.Workbook()

const cellValue = (cell) => {
  if (cell.type === Excel.ValueType.Formula) {
    //return cell.value.result
  } else if (cell.type === Excel.ValueType.RichText) {
    //console.log(JSON.stringify(cell.value, null, 2))
  }
  return cell.toString().replace(/\r\n/g, '\\n')
}

if (!Utils.existsDirectory(config.jsonDefXlsxDir)) {
  console.log(`ディレクトリが存在しません。${config.jsonDefXlsxDir}`) // eslint-disable-line no-console
  return
}
const files = fs.readdirSync(config.jsonDefXlsxDir)

const promises = files.filter((file) => {
  return !file.startsWith('~$') && file.endsWith('.xlsx')
}).map((file) => {
  return () => {
    return new Promise((resolve) => {
      console.log(`${config.jsonDefXlsxDir}/${file} ...`) // eslint-disable-line no-console
      workbook.xlsx.readFile(`${config.jsonDefXlsxDir}/${file}`).then(() => {
        const sheets = []
        workbook.eachSheet((worksheet) => {
          if (!worksheet.name.match(/.*/)) return
          const rows = []
          console.log(`[WorksheetName]${worksheet.name}`)
          worksheet.eachRow((row, rowNumber) => {
            const cells = []
            row.eachCell({includeEmpty: true}, (cell, colNumber) => {
              cells.push(cellValue(cell))
            })
            rows.push(cells)
            // console.log(`${rowNumber}: ${cells.join(', ')}`)
          })
          sheets.push(rows)
          resolve()
        })
      })
    })
  }
})

promises.push(() => {
  return new Promise(() => {
    ejs.renderFile('./buildSrc/src/main/javascript/template/api-def.ejs', {}, {}, (err, html) => {
      console.log('render html')
    })
  })
})

promises.reduce((r, v) => r.then(v), Promise.resolve())
