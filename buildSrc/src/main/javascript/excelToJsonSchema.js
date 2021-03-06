const fs = require('fs')
const Immutable = require('immutable')
const Excel = require('exceljs')
const yaml = require('js-yaml')

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
      console.log(`reading ${config.jsonDefXlsxDir}/${file} ...`) // eslint-disable-line no-console
      const workbook = new Excel.Workbook()
      workbook.xlsx.readFile(`${config.jsonDefXlsxDir}/${file}`).then(() => {
        const sheets = []
        workbook.eachSheet((worksheet) => {
          if (!worksheet.name.match(/.*/)) return
          const rows = []
          worksheet.eachRow((row, rowNumber) => {
            const cells = []
            row.eachCell({includeEmpty: true}, (cell, colNumber) => {
              if (cell.type === Excel.ValueType.RichText) {
                cells.push(cell.value.richText.filter((v) => !Immutable.fromJS(v).getIn(['font', 'strike'])).map((v) => v.text).join('').replace(/^[\r\n]*/g, '').replace(/\r\n/g, ' '))
              } else {
                cells.push(cell.type === Excel.ValueType.RichText ? cell.value : cell.toString())
              }
            })
            rows.push({cells})
          })
          sheets.push({name: worksheet.name, apiId: worksheet.getCell(1, 2).toString(), apiName: worksheet.getCell(1, 4).toString(), rows})
        })
        books.push({name: file, sheets})
        resolve(books)
      })
    })
  }
})

promises.push((books) => {
  return new Promise(() => {
    console.log('generate yml ...') // eslint-disable-line no-console
    books.map((book) => {
      book.sheets.map((sheet) => {
        const api = sheet.rows.reduce((r, row) => {
          // リクエストとレスポンスのオブジェクトに分ける
          if (row.cells.length <= 1) return r
          if (row.cells[0].toLowerCase() === 'request') {
            r.request = []
          } else if (row.cells[0].toLowerCase() === 'response') {
            r.response = []
          }
          const obj = (Number.isInteger(Number(row.cells[1]))) ? {
            level: Number(row.cells[1]),
            logicalName: row.cells[2],
            description: row.cells[3],
            countDef: row.cells[4],
            emptyDef: row.cells[5],
            physicalName: row.cells[6],
            type: row.cells[7],
            remark: row.cells[8],
            children: []
          } : undefined
          if (r.response) {
            r.response.push(obj)
          } else if (r.request) {
            r.request.push(obj)
          }
          return r
        }, {})
        api.id = sheet.apiId
        api.name = sheet.apiName

        const createYaml = (structDef, apiType) => {
          const schema = Immutable.fromJS(structDef).reduce((r, v) => {
            // levelを元にして階層構造を構築
            if (v.get('level') === 1) {
              return r.push(v)
            }
            const findParentKey = (p, v) => {
              if (p.last().get('level') === v.get('level') - 1) {
                return Immutable.List.of(p.findLastKey(() => true))
              }
              return Immutable.fromJS([p.findLastKey(() => true), 'children']).push(...findParentKey(p.last().get('children'), v))
            }
            const parentKey = findParentKey(r, v)
            return r.setIn(parentKey.push('children'), r.getIn(parentKey).get('children').push(v))
          }, Immutable.List.of())
          .reduce((r, v) => {
            // JSON Schema 形式にする
            const getProperty = (v) => {
              const type = Utils.jsonType(v.get('type'))
              const array = Utils.isArray(v.get('countDef'))
              const children = v.get('children').reduce((r, child) => {
                return r.mergeDeep(getProperty(child))
              }, Immutable.fromJS({}))
              const keyPath = (array) ? ['items'] : []
              const props = (type === 'object') ? {type: ['object'], properties: children.toJS()} : {type: [type]}
              return Immutable.fromJS({
                [v.get('physicalName')]: {
                  title: v.get('logicalName'),
                  description: v.get('description'),
                }
              }).mergeDeepIn([v.get('physicalName')], (array) ? {type: ['array'], items: {}} : {})
              .mergeDeepIn([v.get('physicalName'), ...keyPath], props)
            }
            return r.mergeDeep(getProperty(v))
          }, Immutable.fromJS({})).toJS()
          fs.writeFileSync(`${__dirname}/../../../../docs/json-schema/gen/API${api.id}${apiType}.yml`, yaml.safeDump({
            $schema: 'http://json-schema.org/draft-04/hyper-schema',
            title: api.id,
            description: api.name,
            type: ['object'],
            properties: schema
          }))
        }
        createYaml(api.request, 'Request')
        createYaml(api.response, 'Response')
      })
    })
  })
})

promises.reduce((r, v) => r.then(v), Promise.resolve([])).catch((err) => console.log(err)) // eslint-disable-line no-console
