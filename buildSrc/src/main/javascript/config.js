const fs = require('fs')
const JsYaml = require('js-yaml')
const Immutable = require('immutable')
const join = require('path').join

const Utils = require('./utils')

const customFilePath = join(__dirname, '/custom_config.yml')

const customConfig = Utils.existsFile(customFilePath) ? JsYaml.safeLoad(fs.readFileSync(customFilePath)) : {}

module.exports = Immutable.fromJS({
  schemaJsonFilePath: './docs/json-schema/schema.json',
  mainPackageRoot: './web/src/main/kotlin',
  testPackageRoot: './web/src/test/kotlin',
  packageName: 'app.himawari.dto.json',
  sampleJsonDir: './web/src/test/resources/json',
  jsonDefXlsxDir: './docs/xlsx',
  outputHtmlDir: './docs/html',
  csvConvertPaths: [
    `${__dirname}/../../../../dbflute_himawari/playsql/data/common/csv/UTF-8`
  ],
  enumDefFileName: 'ApiEnums.kt'
}).mergeDeep(customConfig).toJS()
