const fs = require('fs')
const Excel = require('exceljs')
const ejs = require('ejs')
const yaml = require('js-yaml')
const Immutable = require('immutable')
const join = require('path').join;

const Utils = require('./utils')
const config = require('./config.js')

const workbook = new Excel.Workbook()

const cellValue = (cell) => {
  if (cell.type === Excel.ValueType.Formula) {
    //return cell.value.result
  } else if (cell.type === Excel.ValueType.RichText) {
    return cell.value.richText.map((v) => {
      const bold = Immutable.fromJS(v).getIn(['font', 'bold']) ? 'font-weight: bold;' : ''
      const strike = Immutable.fromJS(v).getIn(['font', 'strike']) ? 'text-decoration: line-through;' : ''
      const italic = Immutable.fromJS(v).getIn(['font', 'italic']) ? 'font-style: italic;' : ''
      const underline = Immutable.fromJS(v).getIn(['font', 'underline']) ? 'text-decoration: underline;' : ''
      const color = Immutable.fromJS(v).getIn(['font', 'color', 'argb'])
      // style='font-weight: bold; text-decoration: line-through; font-style: italic; text-decoration: underline; color: '
      return `<span style='${bold}${strike}${italic}${underline}${color ? `color: #${color.substring(2)};` : ''}'>${v.text.replace(/\r\n/g, '\\n')}</span>`
    }).join('')
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
  return (books) => {
    return new Promise((resolve) => {
      console.log(`${config.jsonDefXlsxDir}/${file} ...`) // eslint-disable-line no-console
      workbook.xlsx.readFile(`${config.jsonDefXlsxDir}/${file}`).then(() => {
        const sheets = []
        workbook.eachSheet((worksheet) => {
          if (!worksheet.name.match(/.*/)) return
          const rows = []
          worksheet.eachRow((row, rowNumber) => {
            const cells = []
            row.eachCell({includeEmpty: true}, (cell, colNumber) => {
              cells.push(cellValue(cell))
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
    ejs.renderFile(join(__dirname, '/template/api-def.ejs'), {books}, {}, (err, html) => {
      if (err) {
        console.log(`HTMLのrender処理でエラーが発生しました。\n${err}`) // eslint-disable-line no-console
      } else {
        fs.writeFileSync('./docs/excel/excel.html', html)
      }
    })
  })
})

promises.reduce((r, v) => r.then(v), Promise.resolve([]))
