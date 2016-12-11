const fs = require('fs')
const util = require('util')
const parser = require('json-schema-parser')
const immutable = require('immutable')

const buf = fs.readFileSync('./docs/schema/schema.json')
// console.log(JSON.stringify({}, null, 2))
const schemaDef = immutable.fromJS(parser.parse(JSON.parse(buf.toString())))

const printRecursive = (obj, depth, parentKey) => {
  obj.map((v, k) => {
    if (typeof(v) === 'object') {
      if (parentKey === 'properties') {
        console.log(`[${depth}]${k} ${v.get('type').get(0)}`)
      }
      if (k !== 'definitions') {
        printRecursive(v, depth + 1, k)
      }
    }
  })
  // obj.map((v, k) => {
  //   console.log(v, k)
  //   if (v.get('type').contains('object') && v.get('properties') !== undefined) {
  //     printRecursive(v.get('properties'))
  //   } else {
  //     console.log(`******[${k}]${JSON.stringify(v)}`)
  //   }
  // })
}

// console.log(JSON.stringify(schemaDef.toJS(), null, 2))

printRecursive(schemaDef, 1)

// console.log(JSON.stringify(schemaDef.get('properties').toJS(), null, 2))
