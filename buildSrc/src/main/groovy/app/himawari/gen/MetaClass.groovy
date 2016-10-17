package app.himawari.gen

/**
 * Created by masahiro on 2016/10/18.
 */
class MetaClass {
    String className
    String variableName
    List<MetaClass> properties
    JsonType jsonType
    String size

    String getPropertyClassName() {
        return isListProperty() ? "List<${className}>" : className
    }

    Boolean isListProperty() {
        if (size ==~ /0-1/) {
            return false
        }
        if (size.contains("n") || size.contains("-")) {
            return true
        }
        return false
    }
}
