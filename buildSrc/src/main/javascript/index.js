const fs = require('fs')
const util = require('util')
const parser = require('json-schema-parser')
const immutable = require('immutable')

const buf = fs.readFileSync('./docs/schema/schema.json')
// console.log(JSON.stringify({}, null, 2))
const schemaDef = immutable.fromJS(parser.parse(JSON.parse(buf.toString())))

const printRecursive = (obj, depth) => {
  return obj.map((v, k) => {
    if (k !== 'definitions') {
      console.log(`[${depth}]${k} ${v.getIn(['type', 0])} ${v.get('description')}`)
      if (v.getIn(['type', 0]).toLowerCase() === 'object') {
        return immutable.fromJS({[k]: printRecursive(v.get('properties'), depth + 1)})
      } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
        const arrayProp = v.getIn(['items', 'properties'])
        if (arrayProp) {
          return immutable.fromJS({[k]: [printRecursive(arrayProp, depth + 1, k)]})
        }
        // TODO: arrayの中身がobjectではない場合を考慮する
      } else if (v.getIn(['type', 0]).toLowerCase() === 'string') {
        return immutable.fromJS({[k]: '文字列'})
      } else if (v.getIn(['type', 0]).toLowerCase() === 'number') {
        return immutable.fromJS({[k]: 0})
      }
    }
  }).reduce((r, v) => r.mergeDeep(v), immutable.fromJS({}))
}

schemaDef.get('properties').map((v, k) => {
  if (k !== 'error') {
    const obj = printRecursive(immutable.fromJS(v.get('properties')), 1).toJS()
    console.log(`*****${k}*****`)
    console.log(JSON.stringify(obj, null, 2))
  }
})
