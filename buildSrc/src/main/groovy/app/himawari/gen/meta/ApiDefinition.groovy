package app.himawari.gen.meta
/**
 * Created by masahiro on 2016/10/22.
 */
class ApiDefinition {
    String apiIdentifier
    String apiName
    String apiDescription
    List<String> headers = []

    def request = new RequestDefinition()
    def response = new ResponseDefinition()
}
