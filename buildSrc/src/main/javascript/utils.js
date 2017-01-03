const fs = require('fs')

const Immutable = require('immutable')

const booleanTypeDefs = Immutable.fromJS(['ブーリアン', 'ブール', 'Boolean', 'Bool', 'boolean', 'bool'])
const stringTypeDefs = Immutable.fromJS(['文字列', '文字', 'String', 'string'])
const numberTypeDefs = Immutable.fromJS(['数値', '数字', 'Number', 'Num', 'number', 'num'])
const integerTypeDefs = Immutable.fromJS(['整数', 'Integer', 'Int', 'integer', 'int'])
const objectTypeDefs = Immutable.fromJS(['オブジェクト', 'Object', 'object'])

module.exports = {
  existsDirectory: (filePath) => {
    try {
      return fs.statSync(filePath).isDirectory()
    } catch (err) {
      return false
    }
  },
  existsFile: (filePath) => {
    try {
      return fs.statSync(filePath).isFile()
    } catch (err) {
      return false
    }
  },
  jsonType: (type) => {
    if (booleanTypeDefs.contains(type)) {
      return 'boolean'
    } else if (stringTypeDefs.contains(type)) {
      return 'string'
    } else if (numberTypeDefs.contains(type)) {
      return 'number'
    } else if (integerTypeDefs.contains(type)) {
      return 'integer'
    } else if (objectTypeDefs.contains(type)) {
      return 'object'
    }
  },
  isArray: (countDef) => {
    if (countDef.includes('n')) {
      return true
    } else if (countDef.includes('-')) {
      return Number.isInteger(Number(countDef.split('-')[1])) && Number(countDef.split('-')[1]) > 1
    }
    return false
  }
}
