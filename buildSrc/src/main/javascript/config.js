const fs = require('fs')
const JsYaml = require('js-yaml')
const Immutable = require('immutable')

const Utils = require('./utils')

const customFilePath = './buildSrc/src/main/javascript/custom-config.yml'

const customConfig = Utils.existsFile(customFilePath) ? JsYaml.safeLoad(fs.readFileSync(customFilePath)) : {}

module.exports = Immutable.fromJS({
  schemaJsonFilePath: './docs/schema/schema.json',
  mainPackageRoot: './src/main/kotlin',
  testPackageRoot: './src/test/kotlin',
  packageName: 'app.himawari.dto.json.gen',
  sampleJsonDir: './src/test/resources/json/gen',
  jsonDefXlsxDir: './buildSrc/src/main/resources/xlsx',
  outputHtmlDir: './docs/html'
}).mergeDeep(customConfig).toJS()
