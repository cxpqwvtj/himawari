const fs = require('fs')
const Immutable = require('immutable')
const Excel = require('exceljs')
const join = require('path').join
const yaml = require('js-yaml')
const ejs = require('ejs')

const Utils = require('./utils')
const config = require('./config')

if (!Utils.existsDirectory(config.jsonDefXlsxDir)) {
  console.log(`ディレクトリが存在しません。${config.jsonDefXlsxDir}`) // eslint-disable-line no-console
  return
}
const files = fs.readdirSync(config.jsonDefXlsxDir)

const promises = files.filter((file) => {
  return !file.startsWith('~$') && file.endsWith('.xlsx')
}).map((file) => {
  return (books) => {
    return new Promise((resolve) => {
      console.log(`${config.jsonDefXlsxDir}/${file} ...`) // eslint-disable-line no-console
      const workbook = new Excel.Workbook()
      workbook.xlsx.readFile(`${config.jsonDefXlsxDir}/${file}`).then(() => {
        const sheets = []
        workbook.eachSheet((worksheet) => {
          if (!worksheet.name.match(/.*/)) return
          const rows = []
          worksheet.eachRow((row, rowNumber) => {
            const cells = []
            row.eachCell({includeEmpty: true}, (cell, colNumber) => {
              cells.push(cell.type === Excel.ValueType.RichText ? cell.value : cell.toString())
            })
            rows.push({cells})
          })
          sheets.push({name: worksheet.name, rows})
        })
        books.push({name: file, sheets})
        resolve(books)
      })
    })
  }
})

promises.push((books) => {
  return new Promise(() => {
    fs.writeFileSync('./docs/excel/excel.yml', yaml.safeDump(books, {sortKeys: true}))
    ejs.renderFile(join(__dirname, '/template/api_def.ejs'), {Immutable, books}, {}, (err, html) => {
      if (err) {
        console.log(`HTMLのrender処理でエラーが発生しました。\n${err}`) // eslint-disable-line no-console
      } else {
        fs.writeFileSync('./docs/excel/excel.html', html)
      }
    })
  })
})

promises.reduce((r, v) => r.then(v), Promise.resolve([]))
