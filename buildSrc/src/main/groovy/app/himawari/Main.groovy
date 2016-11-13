package app.himawari

import app.himawari.gen.DataClassGenerator

/**
 * Created by masahiro on 2016/10/21.
 */
class Main {
    static void main(String[] args) {
//        new ClassGenerator().generate()
        new DataClassGenerator().generate()
    }
}
