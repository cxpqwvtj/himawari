const fs = require('fs')
const parse = require('csv').parse
const xlsx = require('xlsx')

const config = require('./config')

config.csvConvertPaths.map((csvFilePath) => {
  const filePaths = (fs.statSync(csvFilePath).isDirectory()) ? fs.readdirSync(csvFilePath).filter((v) => v.match(/.*\.csv/)).map(v => `${csvFilePath}/${v}`) : [csvFilePath]
  filePaths.map((filePath) => {
    fs.createReadStream(filePath).pipe(parse({}, (err, data) => {
      if (err) {
        console.log('エラーが発生しました。', err) // eslint-disable-line no-console
      } else {
        const sheet = data.reduce((r, v, rowIndex) => {
          return Object.assign(r, v.reduce((r, v, cellIndex) => {
            r[xlsx.utils.encode_cell({c: cellIndex, r: rowIndex})] = {t: 's', v: v}
            return r
          }, {}))
        }, {})
        sheet['!ref'] = xlsx.utils.encode_range(xlsx.utils.encode_cell({c: 0, r: 0}), xlsx.utils.encode_cell({c: data[0].length - 1, r: data.length - 1}))
        const workbook = { SheetNames:['VACATION_TYPE'], Sheets: {VACATION_TYPE: sheet} }
        xlsx.writeFile(workbook, `${filePath.replace('.csv', '')}.xlsx`)
      }
    }))
  })
})
