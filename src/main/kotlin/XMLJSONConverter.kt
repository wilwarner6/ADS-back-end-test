import org.json.JSONObject
import org.json.XML
import java.io.File
import java.io.PrintWriter
import javax.xml.XMLConstants
import javax.xml.transform.TransformerFactory
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory

class XMLJSONConverter {
    fun convertXmlToJson(xml: String): String {
        val json = XML.toJSONObject(xml)
        return json.toString(4)
    }

    fun convertJsonToXml(json: String): String {
        val jsonObject = JSONObject(json)
        return XML.toString(jsonObject)
    }

    fun convertFile(fileName: String, convertToXML: Boolean) {
        val outputFileName = "converted." + if (convertToXML) "xml" else "json"
        val outputFile = File(outputFileName)
        val printWriter = PrintWriter(outputFile)
        val file = File(fileName)
        var outputString: String
        if (convertToXML) {
            outputString = convertJsonToXml(file.readText())
        } else {
            outputString = convertXmlToJson(file.readText())
        }
        printWriter.print(outputString)
        printWriter.close()

        if (convertToXML) {
            val prettyXmlPath = "prettyXml.xml"
            beautifyXml(outputFileName, prettyXmlPath)
        }
    }

    fun beautifyXml(xmlFilePath: String, outputFilePath: String) {
        val transformerFactory = TransformerFactory.newInstance()
        val transformer = transformerFactory.newTransformer()

        val source = StreamSource(File(xmlFilePath))
        val schemaFile = File(outputFilePath)
        val printWriter = PrintWriter(schemaFile)
        val schemaResult = StreamResult(printWriter)

        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes")
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.METHOD, "xml")
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes")

        transformer.transform(source, schemaResult)
    }

    fun validateXmlAgainstSchema(xmlFilePath: String, schemaFilePath: String): Boolean {
        val schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
        val schema = schemaFactory.newSchema(StreamSource(schemaFilePath))
        val validator = schema.newValidator()
        val streamSource = StreamSource(File(xmlFilePath))

        return try {
            validator.validate(streamSource)
            true
        } catch (e: Exception) {
            false
        }
    }
}