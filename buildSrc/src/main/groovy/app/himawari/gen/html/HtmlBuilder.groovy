package app.himawari.gen.html

import app.himawari.gen.meta.ApiDefinition
import app.himawari.gen.meta.MetaClass

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
<meta charset='UTF-8'>
<title>${title}</title>
${style()}
</head>
<body>
${body(list)}
</body>
</html>
"""
    }

    private String body(List<ApiDefinition> list) {
        def sb = new StringBuffer()
        sb.append("<h2>${title}</h2>\n")
        sb.append("<table>\n")
        sb.append("<thead>\n")
        sb.append("<tr><th>No</th><th>ID</th><th>name</th></tr>\n")
        sb.append("</thead>\n")
        sb.append("<tbody>\n")
        list.eachWithIndex { apiDef, index ->
            sb.append("<tr>\n")
            sb.append("<td>${index + 1}</td>\n")
            sb.append("<td><a href='#${apiDef.apiIdentifier}'>${apiDef.apiIdentifier}</a></td>\n")
            sb.append("<td>${apiDef.apiName}</td>\n")
            sb.append("</tr>\n")
        }
        sb.append("</tbody>\n")
        sb.append("</table>\n")
        list.each { apiDef ->
            sb.append("<h2 id='${apiDef.apiIdentifier}'>${apiDef.apiIdentifier} ${apiDef.apiName}</h2>\n")
            sb.append("<div>リクエスト</div>\n")
            sb.append(apiTable(apiDef.headers, apiDef.request))
            sb.append("<div>レスポンス</div>\n")
            sb.append(apiTable(apiDef.headers, apiDef.response))
            sb.append("<hr />")
        }
        return sb.toString()
    }

    private static String apiTable(List<String> headers, MetaClass meta) {
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
        sb.append(row(meta.properties));
        sb.append("</tbody>\n")
        sb.append("</table>")
        return sb.toString()
    }

    private static String row(List<MetaClass> list) {
        def sb = new StringBuffer()
        list.each { meta ->
            sb.append("<tr>\n")
            sb.append("<td style='padding-left: ${3 * meta.level}px'>")
            sb.append(meta.levelDef.replaceAll("\n", "<br />"))
            sb.append("</td>\n")
            sb.append("<td>")
            sb.append(meta.logicalNameDef.replaceAll("\n", "<br />"))
            sb.append("</td>\n")
            sb.append("<td>")
            sb.append(meta.descriptionDef.replaceAll("\n", "<br />"))
            sb.append("</td>\n")
            sb.append("<td style='text-align: center'>")
            sb.append(meta.sizeDef.replaceAll("\n", "<br />"))
            sb.append("</td>\n")
            sb.append("<td>")
            sb.append(meta.emptyConditionDef.replaceAll("\n", "<br />"))
            sb.append("</td>\n")
            sb.append("<td>")
            sb.append(meta.variableNameDef.replaceAll("\n", "<br />"))
            sb.append("</td>\n")
            sb.append("<td>")
            sb.append(meta.jsonTypeDef.replaceAll("\n", "<br />"))
            sb.append("</td>\n")
            sb.append("<td>")
            sb.append(meta.noteDef.replaceAll("\n", "<br />"))
            sb.append("</td>\n")
            sb.append("</tr>\n")
            if (!meta.properties.isEmpty()) {
                sb.append(row(meta.properties))
            }
        }
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
padding: 2px;
vertical-align: top;
color: #333;
background-color: #2EFEF7;
border: 1px solid #999;
}
table tbody td {
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
