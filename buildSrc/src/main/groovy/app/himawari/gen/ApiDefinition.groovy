package app.himawari.gen

/**
 * Created by masahiro on 2016/10/22.
 */
class ApiDefinition {
    String apiIdentifier
    String apiName
    String apiDescription

    def request = new RequestDefinition()
    def response = new ResponseDefinition()
}
