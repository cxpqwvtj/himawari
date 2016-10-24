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

    MetaClass request
    MetaClass response

    ApiDefinition(String classNamePrefix, String apiIdentifier, String apiName, String apiDescription) {
        this.classNamePrefix = classNamePrefix
        this.apiIdentifier = apiIdentifier
        this.apiName = apiName
        this.apiDescription = apiDescription

        def classNameBase = "${classNamePrefix}Api${apiIdentifier[0].toUpperCase()}${apiIdentifier[1..<apiIdentifier.size()]}"
        def className = "${classNameBase[0].toLowerCase()}${classNameBase[1..<classNameBase.size()]}"
        request = new MetaClass("リクエスト", "${className}Request")
        response = new MetaClass("レスポンス", "${className}}Response")
    }
}
