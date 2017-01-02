const fs = require('fs')
const path = require('path')

const yaml = require('js-yaml')
const $RefParser = require('json-schema-ref-parser')
const ejs = require('ejs')

const schemataDir = path.join(__dirname, '/../../../../docs/schema/schemata')
const outputDir = path.join(schemataDir, '/../gen')
const schemaIndexFile = path.join(__dirname, '/../../../../src/main/client/constants/schema.js')

try {
  fs.statSync(outputDir).isDirectory()
} catch (err) {
  //console.log(err) // eslint-disable-line no-console
  fs.mkdirSync(outputDir)
}

const existsGenFiles = fs.readdirSync(outputDir)
existsGenFiles.map((fileName) => {
  fs.unlinkSync(`${outputDir}/${fileName}`)
})

const schemaDefFiles = fs.readdirSync(schemataDir)
const promises = schemaDefFiles.filter((v) => !v.startsWith('_')).map((fileName) => {
  return () => {
    return new Promise((resolve) => {
      $RefParser.dereference(`${schemataDir}/${fileName}`, (err, schema) => {
        fs.writeFileSync(`${outputDir}/${fileName}`, yaml.safeDump(schema, {noRefs: true}))
        resolve()
      })
    })
  }
})
promises.push(() => {
  new Promise(() => {
    const generatedFiles = fs.readdirSync(outputDir)
    ejs.renderFile(path.join(__dirname, '/template/json_schema_index.ejs'), {generatedFiles}, null, (err, value) => {
      if (err) {
        console.log(err) // eslint-disable-line no-console
      } else {
        fs.writeFileSync(schemaIndexFile, value)
      }
    })
  })
})

promises.reduce((r, v) => r.then(v), Promise.resolve([]))
