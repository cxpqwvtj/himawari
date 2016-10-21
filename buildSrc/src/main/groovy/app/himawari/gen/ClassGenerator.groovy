package app.himawari.gen

import groovy.io.FileType
import org.apache.tools.ant.taskdefs.Classloader

/**
 * Created by masahiro on 2016/10/20.
 */
class ClassGenerator {
    void generate() {
        def configFileUrl = new File("buildSrc/src/main/resources/config/default.config").toURI().toURL()
        //def configFileUrl = ClassLoader.getSystemResource("config/default.config")
        def defaultConfig = new ConfigSlurper().parse(configFileUrl)
        println(defaultConfig)
        def customConfig
        new File("../sample").eachFileMatch(FileType.FILES, /.*\.xlsx/) {
            println("${it.name}")
        }
    }
}
