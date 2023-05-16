import org.json.JSONObject
import org.json.XML

class XMLJSONConverter {
    fun convertXmlToJson(xml: String) {
        val json = XML.toJSONObject(xml)
    }
}