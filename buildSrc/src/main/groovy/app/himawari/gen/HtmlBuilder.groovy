package app.himawari.gen

/**
 * Created by masahiro on 2016/10/22.
 */
class HtmlBuilder {
    private String title

    HtmlBuilder(String title) {
        this.title = title
    }

    String toHtml(List<ApiDefinition> list) {
        return """<!DOCTYPE html>
<html lang='ja'>
<head>
<title>${title}</title>
${style()}
</head>
<body>
${body(list)}
</body>
</html>
"""
    }

    private static String body(List<ApiDefinition> list) {
        def sb = new StringBuffer()
        list.each { apiDef ->
            sb.append("<h2>${apiDef.apiIdentifier} ${apiDef.apiName}</h2>\n")
            sb.append("<div>リクエスト</div>\n")
            sb.append(apiTable(apiDef.headers, apiDef.request.properties))
            sb.append("<div>レスポンス</div>\n")
            sb.append(apiTable(apiDef.headers, apiDef.response.properties))
        }
        return sb.toString()
    }

    private static String apiTable(List<String> headers, List<MetaClass> list) {
        def sb = new StringBuffer()
        sb.append("<table>\n")
        sb.append("<thead>\n")
        sb.append("<tr>\n")
        headers.each {
            sb.append("<th>${it}</th>\n")
        }
        sb.append("</tr>\n")
        sb.append("</thead>\n")
        sb.append("<tbody>\n")
        list.each { meta ->
            sb.append("<tr>")
            sb.append("\n")
            sb.append("<td style='padding-left: ${3 * meta.level}px'>")
            sb.append(meta.levelDef.replaceAll("\n", "<br />"))
            sb.append("</td>")
            sb.append("\n")
            sb.append("<td>")
            sb.append(meta.logicalNameDef.replaceAll("\n", "<br />"))
            sb.append("</td>")
            sb.append("\n")
            sb.append("<td>")
            sb.append(meta.descriptionDef.replaceAll("\n", "<br />"))
            sb.append("</td>")
            sb.append("\n")
            sb.append("<td style='text-align: center'>")
            sb.append(meta.sizeDef.replaceAll("\n", "<br />"))
            sb.append("</td>")
            sb.append("\n")
            sb.append("<td>")
            sb.append(meta.emptyConditionDef.replaceAll("\n", "<br />"))
            sb.append("</td>")
            sb.append("\n")
            sb.append("<td>")
            sb.append(meta.variableNameDef.replaceAll("\n", "<br />"))
            sb.append("</td>")
            sb.append("\n")
            sb.append("<td>")
            sb.append(meta.jsonTypeDef.replaceAll("\n", "<br />"))
            sb.append("</td>")
            sb.append("\n")
            sb.append("<td>")
            sb.append(meta.noteDef.replaceAll("\n", "<br />"))
            sb.append("</td>")
            sb.append("\n")
            sb.append("</tr>")
            sb.append("\n")
        }
        sb.append("</tbody>\n")
        sb.append("</table>")
        return sb.toString()
    }

    private static String style() {
        return """<style type="text/css">
<!--
body {
  display: block;
  margin: 8px;
}
h2 {
margin: 5px 0px;
}
table {
border-collapse: collapse;
border-right: 1px solid #999;
font-size: 12px;
}
table thead th {
<!--width: 150px;-->
padding: 2px;
vertical-align: top;
color: #333;
background-color: #eee;
border: 1px solid #999;
}
table tbody td {
<!--width: 150px;-->
padding: 2px;
background-color: #fff;
border-bottom: 1px solid #999;
border-left: 1px solid #999;
}
-->
</style>
"""
    }
}
