package app.himawari.gen.meta
/**
 * Created by masahiro on 2016/10/22.
 */
class ApiDefinition {
    String classNamePrefix = ""
    String apiIdentifier
    String apiName
    String apiDescription
    List<String> headers = []

    def request = new RequestDefinition()
    def response = new ResponseDefinition()

    String classNameBase() {
        return "${apiIdentifier[0].toUpperCase()}${apiIdentifier[1..<apiIdentifier.size()]}"
    }

    String requestClassName() {
        return "${classNamePrefix}Api${classNameBase()}Request"
    }

    String responseClassName() {
        return "${classNamePrefix}Api${classNameBase()}Rsponse"
    }
}
