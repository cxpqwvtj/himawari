const fs = require('fs')

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
  }
}
