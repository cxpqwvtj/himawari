const fs = require('fs')
const path = require('path')

const $RefParser = require('json-schema-ref-parser')
const Immutable = require('immutable')

const config = require('./config')

const schemataDir = path.join(__dirname, '/../../../../docs/schema/schemata')

const exampleJson = (propertyName, jsonDef) => {
  if (jsonDef.getIn(['type', 0]).toLowerCase() === 'object') {
    const properties = jsonDef.get('properties')
    return properties.map((v, k) => {
      return Immutable.fromJS({[k]: exampleJson(k, v)})
    }).reduce((r, v) => r.mergeDeep(v))
  } else if (jsonDef.getIn(['type', 0]).toLowerCase() === 'array') {
    const properties = jsonDef.getIn(['items', 'properties'])
    return properties.map((v, k) => {
      return Immutable.fromJS([{[k]: exampleJson(k, v)}])
    }).reduce((r, v) => r.mergeDeep(v))
  } else if (jsonDef.getIn(['type', 0]).toLowerCase() === 'string') {
    return '文字列'
  } else if (jsonDef.getIn(['type', 0]).toLowerCase() === 'number') {
    return 0
  } else {
    console.log(`不明な型定義です。${jsonDef.get('type')}`) // eslint-disable-line no-console
  }
}

const generateKotlinDataClass = (propertyName, jsonDef, depth) => {
  const indent = Immutable.Range(0, depth).map(() => '    ').reduce((r, v) => r + v, '')
  if (jsonDef.get('type').map(v => v.toLowerCase()).contains('object') ||
    jsonDef.get('type').map(v => v.toLowerCase()).contains('array')) {
    const properties = jsonDef.get('properties') || jsonDef.getIn(['items', 'properties'])
    const children = properties.map((v, k) => {
      return generateKotlinDataClass(k, v, depth + 1)
    }).filter(v => v).map(v => `\n${v}`).join('')
    const inner = children === '' ? '' : ` {${children}\n${indent}}`
    return `${generateClassComment(propertyName, jsonDef, depth + 1)}${indent}@JsonInclude(JsonInclude.Include.NON_NULL)\n${indent}data class ${propertyName[0].toUpperCase()}${propertyName.substring(1)}(${generateVariable(propertyName, jsonDef, depth + 2)})${inner}`
  }
}

const generateVariable = (propertyName, jsonDef, depth) => {
  const indent = Immutable.Range(0, depth).map(() => '    ').join('')
  const properties = jsonDef.get('properties') || jsonDef.getIn(['items', 'properties']) || Immutable.fromJS({})
  return properties.map((v, k) => {
    const requiredField = (jsonDef.get('required') || Immutable.fromJS([])).contains(k)
    const requiredMark = requiredField ? '' : '?'
    const className = `${k[0].toUpperCase()}${k.substring(1)}`
    if (v.getIn(['type', 0]).toLowerCase() === 'object') {
      return `${indent}var ${k}: ${className}${requiredMark} = ${requiredField ? `${className}()` : 'null'}`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
      return `${indent}var ${k}: List<${className}>${requiredMark} = ${requiredField ? 'listOf()' : 'null'}`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'string') {
      return `${indent}var ${k}: String${requiredMark} = ${requiredField ? '""' : 'null'}`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'number') {
      return `${indent}var ${k}: Int${requiredMark} = ${requiredField ? '0' : 'null'}`
    } else {
      console.log(`不明な型定義です。${v.get('type')}`) // eslint-disable-line no-console
    }
  }).map(v => `\n${v}`).join(',')
}

const generateClassComment = (propertyName, jsonDef, depth) => {
  const indent = Immutable.Range(0, depth - 1).map(() => '    ').reduce((r, v) => r + v, '')
  const properties = jsonDef.get('properties') || jsonDef.getIn(['items', 'properties']) || Immutable.fromJS({})
  const propertiesComment = properties.map((v, k) => {
    return `${indent} * @property ${k} ${v.get('description').replace('\n', '<br />')}`
  }).map(v => `\n${v}`).join('')
  return `${indent}/**\n${indent} * ${jsonDef.get('description').replace('\n', '<br />')}${propertiesComment}\n${indent} */\n`
}

const generateKotlinTestClass = (k, v) => {
  return [
    '// Code generated by Node.js script',
    `package ${config.packageName}`,
    '',
    'import com.fasterxml.jackson.databind.ObjectMapper',
    'import org.junit.jupiter.api.Test',
    '',
    '/**',
    ` * ${k}のテストクラスです`,
    ' */',
    `internal class ${k}Test {`,
    '    @Test',
    '    fun fullProperty() {',
    `        val ${k[0].toLowerCase()}${k.substring(1)} = ${k}().apply {${generateKotlinTestVariable(k, v, 3)}`,
    '        }',
    `        println(ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(${k[0].toLowerCase()}${k.substring(1)}))`,
    '    }',
    '}'
  ].join('\n')
}

const generateKotlinTestVariable = (propertyName, jsonDef, depth) => {
  const indent = Immutable.Range(0, depth).map(() => '    ').join('')
  const properties = jsonDef.get('properties') || jsonDef.getIn(['items', 'properties']) || Immutable.fromJS({})
  return properties.map((v, k) => {
    const className = `${propertyName}.${k[0].toUpperCase()}${k.substring(1)}`
    if (v.getIn(['type', 0]).toLowerCase() === 'object') {
      return `${indent}${k} = ${className}().apply {${generateKotlinTestVariable(className, v, depth + 1)}\n${indent}}`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'array') {
      return `${indent}${k} = listOf(${className}().apply {${generateKotlinTestVariable(className, v, depth + 1)}\n${indent}})`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'string') {
      return `${indent}${k} = ""`
    } else if (v.getIn(['type', 0]).toLowerCase() === 'number') {
      return `${indent}${k} = 0`
    } else {
      console.log(`不明な型定義です。${v.get('type')}`) // eslint-disable-line no-console
    }
  }).map(v => `\n${v}`).join('')
}

const schemaDefFiles = fs.readdirSync(schemataDir)
const promises = schemaDefFiles.filter((v) => !v.startsWith('_')).map((fileName) => {
  return () => {
    return new Promise((resolve, reject) => {
      $RefParser.dereference(`${schemataDir}/${fileName}`, (err, schema) => {
        if (err) {
          reject(err)
          return
        }

        const schemaName = fileName.replace('.yml', '')
        const properties = Immutable.fromJS(schema)
        console.log(`generate ${schemaName}...`) // eslint-disable-line no-console
        const obj = exampleJson(schemaName, properties, 1).toJS()
        fs.writeFileSync(`${config.sampleJsonDir}/${schemaName}.json`, JSON.stringify(obj, null, 2))
        const kotlinClass = `// Code generated by Node.js script\npackage ${config.packageName}\n\nimport com.fasterxml.jackson.annotation.JsonInclude\n\n${generateKotlinDataClass(schemaName, properties, 0)}\n`
        const mainClassFileDir = `${config.mainPackageRoot}/${config.packageName.replace(/\./g, '/')}`
        fs.writeFileSync(`${mainClassFileDir}/${schemaName}.kt`, kotlinClass)
        const testClassFileDir = `${config.testPackageRoot}/${config.packageName.replace(/\./g, '/')}`
        fs.writeFileSync(`${testClassFileDir}/${schemaName}Test.kt`, generateKotlinTestClass(schemaName, properties))

        resolve()
      })
    })
  }
})

promises.reduce((r, v) => r.then(v), Promise.resolve([]))
