package app.himawari.gen

import app.himawari.gen.meta.DataClassMeta
import org.gradle.internal.impldep.org.yaml.snakeyaml.Yaml

/**
 * kotlinの data class 生成クラス
 * Created by masahiro on 2016/11/13.
 */
class DataClassGenerator {

    void generate() {
        // TODO: yamlファイルを外から指定できるようにする
        new Yaml().loadAll(new FileInputStream(new File("./docs/mock/settings.yml"))).each {
            // TODO: ファイル生成する
            println new DataClassMeta(it).generateClass()
        }
    }
}
