const fs = require('fs')
const util = require('util')
const parser = require('json-schema-parser')
const Immutable = require('immutable')

const buf = fs.readFileSync('./docs/schema/schema.json')
// console.log(JSON.stringify({}, null, 2))
const schemaDef = Immutable.fromJS(parser.parse(JSON.parse(buf.toString())))

const exampleJson = (propertiesDef, depth) => {
  return propertiesDef.map((v, k) => {
    if (k !== 'definitions') {
      if (v.getIn(['type', 0]).toLowerCase() === 'object') {
        return Immutable.fromJS({[k]: exampleJson(v.get('properties'), depth + 1)})
      } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
        const arrayProp = v.getIn(['items', 'properties'])
        if (arrayProp) {
          return Immutable.fromJS({[k]: [exampleJson(arrayProp, depth + 1, k)]})
        }
        // TODO: arrayの中身がobjectではない場合を考慮する
      } else if (v.getIn(['type', 0]).toLowerCase() === 'string') {
        return Immutable.fromJS({[k]: '文字列'})
      } else if (v.getIn(['type', 0]).toLowerCase() === 'number') {
        return Immutable.fromJS({[k]: 0})
      }
    }
  }).reduce((r, v) => r.mergeDeep(v), Immutable.fromJS({}))
}

const generateVariable = (propertiesDef, depth) => {
  const indent = Immutable.Range(0, depth).map(() => '  ').reduce((r, v) => r + v, '')
  return propertiesDef.map((v, k) => {
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

const generateClassComment = (propertiesDef, depth) => {
  const indent = Immutable.Range(0, depth - 1).map(() => '  ').reduce((r, v) => r + v, '')
  const propertiesComment = propertiesDef.map((v, k) => {
    if (k !== 'definitions') {
      return `${indent} * @property ${k} ${v.get('description').replace('\n', '<br />')}`
    }
  }).join('\n')
  return `${indent}/**\n${propertiesComment}\n${indent} */\n`
}

const generateKotlinDataClass = (propertiesDef, depth) => {
  const indent = Immutable.Range(0, depth).map(() => '  ').reduce((r, v) => r + v, '')
  const classDefs = propertiesDef.map((v, k) => {
    if (k !== 'definitions') {
      // console.log(`[${depth}]${k} ${v.getIn(['type', 0])} ${v.get('description')}`)
      if (v.getIn(['type', 0]).toLowerCase() === 'object') {
        return `${generateClassComment(v.get('properties'), depth + 1)}${indent}data class ${k[0].toUpperCase()}${k.substring(1)} (${generateVariable(v.get('properties'), depth + 1)})${generateKotlinDataClass(v.get('properties'), depth + 1)}`
        // return Immutable.fromJS({[k]: generateKotlinDataClass(v.get('properties'), depth + 1)})
      } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
        const arrayProp = v.getIn(['items', 'properties'])
        if (arrayProp) {
          return `${generateClassComment(v.getIn(['items', 'properties']), depth + 1)}${indent}data class ${k[0].toUpperCase()}${k.substring(1)} (${generateVariable(v.getIn(['items', 'properties']), depth + 1)})${generateKotlinDataClass(v.getIn(['items', 'properties']), depth + 1)}`
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
    const obj = exampleJson(v.get('properties'), 1).toJS()
    console.log(`***** ${k} *****`)
    console.log(JSON.stringify(obj, null, 2))
    const classComment = generateClassComment(v.get('properties'), 1)
    const variables = generateVariable(v.get('properties'), 1)
    const dataClasses = generateKotlinDataClass(v.get('properties'), 1)
    console.log(`${classComment}data class ${k}(${variables})${dataClasses}`)
    console.log('')
  }
})
