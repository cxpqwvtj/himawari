package app.himawari

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by masahiro on 2016/10/13.
 */
class JsonSchema {
    void read() {
        def mapper = new ObjectMapper()
        def map = mapper.readValue(new File("./docs/schema/schema.json"), new TypeReference<Map<String, Object>>() {})
        println map
    }
}
