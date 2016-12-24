const fs = require('fs')
const util = require('util')
const parser = require('json-schema-parser')
const Immutable = require('immutable')

const buf = fs.readFileSync('./docs/schema/schema.json')
const schemaDef = Immutable.fromJS(parser.parse(JSON.parse(buf.toString())))

const exampleJson = (propertyName, jsonDef) => {
  if (jsonDef.getIn(['type', 0]).toLowerCase() === 'object' || jsonDef.getIn(['type', 0]).toLowerCase() === 'array') {
    const properties = jsonDef.get('properties') || jsonDef.getIn(['items', 'properties'])
    return properties.map((v, k) => {
      return Immutable.fromJS({[k]: exampleJson(k, v)})
    }).reduce((r, v) => r.mergeDeep(v))
  } else if (jsonDef.getIn(['type', 0]).toLowerCase() === 'string') {
    return '文字列'
  } else if (jsonDef.getIn(['type', 0]).toLowerCase() === 'number') {
    return 0
  } else {
    console.log(`不明な型定義です。${jsonDef.get('type')}`) // eslint-disable-line no-console
  }
}

const generateVariable = (propertyName, jsonDef, depth) => {
  const indent = Immutable.Range(0, depth).map(() => '  ').join('')
  const properties = jsonDef.get('properties') || jsonDef.getIn(['items', 'properties']) || Immutable.fromJS({})
  return properties.map((v, k) => {
    if (v.getIn(['type', 0]).toLowerCase() === 'object') {
      return `${indent}var ${k}: ${k[0].toUpperCase()}${k.substring(1)}`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
      return `${indent}var ${k}: List<${k[0].toUpperCase()}${k.substring(1)}>`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'string') {
      return `${indent}var ${k}: String`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'number') {
      return `${indent}var ${k}: Int`
    } else {
      console.log(`不明な型定義です。${v.get('type')}`) // eslint-disable-line no-console
    }
  }).map(v => `\n${v}`).join(',')
}

const generateClassComment = (proppropertyName, jsonDef, depth) => {
  const indent = Immutable.Range(0, depth - 1).map(() => '  ').reduce((r, v) => r + v, '')
  const properties = jsonDef.get('properties') || jsonDef.getIn(['items', 'properties']) || Immutable.fromJS({})
  const propertiesComment = properties.map((v, k) => {
    return `${indent} * @property ${k} ${v.get('description').replace('\n', '<br />')}`
  }).map(v => `\n${v}`).join('')
  return `${indent}/**\n${indent} * ${jsonDef.get('description').replace('\n', '<br />')}${propertiesComment}\n${indent} */\n`
}

const generateKotlinDataClass = (propertyName, jsonDef, depth) => {
  const indent = Immutable.Range(0, depth).map(() => '  ').reduce((r, v) => r + v, '')
  if (jsonDef.get('type').map(v => v.toLowerCase()).contains('object') ||
    jsonDef.get('type').map(v => v.toLowerCase()).contains('array')) {
    const properties = jsonDef.get('properties') || jsonDef.getIn(['items', 'properties'])
    const children = properties.map((v, k) => {
      return generateKotlinDataClass(k, v, depth + 1)
    }).filter(v => v).map(v => `\n${v}`).join('')
    const inner = children === '' ? '' : ` {${children}\n${indent}}`
    return `${generateClassComment(propertyName, jsonDef, depth + 1)}${indent}data class ${propertyName[0].toUpperCase()}${propertyName.substring(1)}(${generateVariable(propertyName, jsonDef, depth + 2)})${inner}`
  }
}

schemaDef.get('properties').map((v, k) => {
  if (k !== 'error') {
    console.log(`***** ${k} *****`)
    const obj = exampleJson(k, v, 1).toJS()
    console.log(JSON.stringify(obj, null, 2))
    console.log(generateKotlinDataClass(k, v, 0))
    console.log('')
  }
})
