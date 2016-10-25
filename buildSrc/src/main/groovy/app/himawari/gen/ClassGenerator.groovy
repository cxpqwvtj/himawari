package app.himawari.gen

import app.himawari.gen.excel.JsonSpecExcel
import app.himawari.gen.html.HtmlBuilder
import app.himawari.gen.meta.ApiDefinition
import groovy.io.FileType

/**
 * Created by masahiro on 2016/10/23.
 */
class ClassGenerator {

    ConfigObject config

    ClassGenerator(){
        def configDir = new File("buildSrc/src/main/resources/config").toPath()
        def configFileUrl = configDir.resolve("default.config").toUri().toURL()
        def defaultConfig = new ConfigSlurper().parse(configFileUrl)
        def customConfigFile = configDir.resolve("custom.config").toFile()
        config = (customConfigFile.exists()) ? (ConfigObject)defaultConfig.merge(new ConfigSlurper().parse(customConfigFile.toURI().toURL())) : defaultConfig
    }

    void generate() {
        def excelDir = new File("${config.excel.dir}")
        if (excelDir.exists()) {
            def apiDefinitions = []
            excelDir.eachFileMatch(FileType.FILES, ~/.*xlsx/) {
                if (it.name.startsWith("~")) return
                apiDefinitions.addAll(new JsonSpecExcel(it).read())
            }
            generateClass(apiDefinitions)
        } else {
            println("ディレクトリが存在しません。${config.excel.dir}")
        }
    }

    private void generateClass(List<ApiDefinition> apiDefinitions) {
        apiDefinitions.each { apiDefinition ->
            def sb = new StringBuffer()
            // リクエスト用
            sb.append("package ${config.classParam.packageName}\n")
            sb.append("\n")
            sb.append("data class ${apiDefinition.request.className}")
            apiDefinition.request.properties.each { property ->
                // TODO: JsonSpecExcelでデータを階層構造で保持するようにしてから実装する
            }
            println(sb.toString())
            // レスポンス用
        }
    }
}
