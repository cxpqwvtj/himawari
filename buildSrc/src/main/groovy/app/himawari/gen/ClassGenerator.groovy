package app.himawari.gen

import groovy.io.FileType

/**
 * Created by masahiro on 2016/10/20.
 */
class ClassGenerator {
    void generate() {
        new File("../sample").eachFileMatch(FileType.FILES, /.*\.xlsx/) {
            println("${it.name}")
        }
    }
}
