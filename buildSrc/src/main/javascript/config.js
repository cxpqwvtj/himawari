const fs = require('fs')
const JsYaml = require('js-yaml')
const Immutable = require('immutable')
const join = require('path').join;

const Utils = require('./utils')

const customFilePath = join(__dirname, '/custom_config.yml')

const customConfig = Utils.existsFile(customFilePath) ? JsYaml.safeLoad(fs.readFileSync(customFilePath)) : {}

module.exports = Immutable.fromJS({
  schemaJsonFilePath: './docs/schema/schema.json',
  mainPackageRoot: './src/main/kotlin',
  testPackageRoot: './src/test/kotlin',
  packageName: 'app.himawari.dto.json.gen',
  sampleJsonDir: './src/test/resources/json/gen',
  jsonDefXlsxDir: './docs/xlsx',
  outputHtmlDir: './docs/html'
}).mergeDeep(customConfig).toJS()
