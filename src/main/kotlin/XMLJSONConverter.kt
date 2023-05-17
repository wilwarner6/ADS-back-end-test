import org.json.JSONObject
import org.json.XML

class XMLJSONConverter {
    fun convertXmlToJson(xml: String): String {
        val json = XML.toJSONObject(xml)
        return json.toString(4)
    }
    fun jsonToXml(json: String): String {
        val jsonObject = JSONObject(json)
        return XML.toString(jsonObject)
    }
}