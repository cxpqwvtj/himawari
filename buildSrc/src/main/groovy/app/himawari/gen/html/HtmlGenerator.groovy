package app.himawari.gen.html

import app.himawari.gen.excel.JsonSpecExcel
import app.himawari.gen.html.HtmlBuilder
import groovy.io.FileType

/**
 * Created by masahiro on 2016/10/20.
 */
class HtmlGenerator {
    void generate() {
        def configDir = new File("buildSrc/src/main/resources/config").toPath()
        def configFileUrl = configDir.resolve("default.config").toUri().toURL()
        def defaultConfig = new ConfigSlurper().parse(configFileUrl)
        def customConfigFile = configDir.resolve("custom.config").toFile()
        def config = (customConfigFile.exists()) ? defaultConfig.merge(new ConfigSlurper().parse(customConfigFile.toURI().toURL())) : defaultConfig
        def excelDir = new File("${config.excel.dir}")
        if (excelDir.exists()) {
            def apiDefinitions = []
            excelDir.eachFileMatch(FileType.FILES, ~/.*xlsx/) {
                if (it.name.startsWith("~")) return
                apiDefinitions.addAll(new JsonSpecExcel(it).read())
            }
            def outputFile = new File("${config.excel.dir}").toPath().resolve("api-definition.html").toFile()
            outputFile.write(new HtmlBuilder("API Definition").toHtml(apiDefinitions))
        } else {
            println("ディレクトリが存在しません。${config.excel.dir}")
        }
    }
}