const fs = require('fs')
const util = require('util')
const parser = require('json-schema-parser')
const immutable = require('immutable')

const buf = fs.readFileSync('./docs/schema/schema.json')
// console.log(JSON.stringify({}, null, 2))
const schemaDef = immutable.fromJS(parser.parse(JSON.parse(buf.toString())))

const exampleJson = (obj, depth) => {
  return obj.map((v, k) => {
    if (k !== 'definitions') {
      if (v.getIn(['type', 0]).toLowerCase() === 'object') {
        return immutable.fromJS({[k]: exampleJson(v.get('properties'), depth + 1)})
      } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
        const arrayProp = v.getIn(['items', 'properties'])
        if (arrayProp) {
          return immutable.fromJS({[k]: [exampleJson(arrayProp, depth + 1, k)]})
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

const generateVariable = (obj, depth) => {
  const indent = immutable.Range(0, depth).map(() => '  ').reduce((r, v) => r + v, '')
  return obj.map((v, k) => {
    if (k !== 'definitions') {
      if (v.getIn(['type', 0]).toLowerCase() === 'object') {
        return `${indent}var ${k}: ${k[0].toUpperCase()}${k.substring(1)}`
      } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
        const arrayProp = v.getIn(['items', 'properties'])
        if (arrayProp) {
          return `${indent}var ${k}: List<${k[0].toUpperCase()}${k.substring(1)}>`
        }
        // TODO: arrayの中身がobjectではない場合を考慮する
      } else if (v.getIn(['type', 0]).toLowerCase() === 'string') {
        return `${indent}var ${k}: String`
      } else if (v.getIn(['type', 0]).toLowerCase() === 'number') {
        return `${indent}var ${k}: Int`
      }
    }
  }).map(v => `\n${v}`)
  .join(',')
}

const generateKotlinDataClass = (obj, depth) => {
  const indent = immutable.Range(0, depth).map(() => '  ').reduce((r, v) => r + v, '')
  const classDefs = obj.map((v, k) => {
    if (k !== 'definitions') {
      // console.log(`[${depth}]${k} ${v.getIn(['type', 0])} ${v.get('description')}`)
      if (v.getIn(['type', 0]).toLowerCase() === 'object') {
        return `${indent}data class ${k[0].toUpperCase()}${k.substring(1)} (${generateVariable(immutable.fromJS(v.get('properties')), depth + 1)})${generateKotlinDataClass(immutable.fromJS(v.get('properties')), depth + 1)}`
        // return immutable.fromJS({[k]: generateKotlinDataClass(v.get('properties'), depth + 1)})
      } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
        const arrayProp = v.getIn(['items', 'properties'])
        if (arrayProp) {
          return `${indent}data class ${k[0].toUpperCase()}${k.substring(1)} (${generateVariable(immutable.fromJS(v.getIn(['items', 'properties'])), depth + 1)})${generateKotlinDataClass(immutable.fromJS(v.getIn(['items', 'properties'])), depth + 1)}`
        }
        // TODO: arrayの中身がobjectではない場合を考慮する
      }
    }
  }).filter(v => v)

  if (classDefs.size == 0) {
    return ''
  } else {
    return ` {\n${classDefs.join('\n')}\n${indent}}`
  }
}

schemaDef.get('properties').map((v, k) => {
  if (k !== 'error') {
    const obj = exampleJson(immutable.fromJS(v.get('properties')), 1).toJS()
    console.log(`***** ${k} *****`)
    console.log(JSON.stringify(obj, null, 2))
    console.log(`data class ${k}(${generateVariable(immutable.fromJS(v.get('properties')), 1)})${generateKotlinDataClass(immutable.fromJS(v.get('properties')), 1)}`)
    console.log('')
  }
})
