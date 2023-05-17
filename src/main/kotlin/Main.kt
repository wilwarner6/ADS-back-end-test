import java.io.File
import java.io.PrintWriter

fun convertFile(fileName: String, convertToXML: Boolean) {
    val outputFileName = "converted." + if (convertToXML) "xml" else "json"
    val outputFile = File(outputFileName)
    val printWriter = PrintWriter(outputFile)
    val fileConverter = XMLJSONConverter()
    val file = File(fileName)
    var outputString: String
    if (convertToXML) {
        outputString = fileConverter.convertJsonToXml(file.readText())
    } else {
        outputString = fileConverter.convertXmlToJson(file.readText())
    }
    printWriter.print(outputString)
    printWriter.close()
}
fun main(args: Array<String>) {
    if (args.size == 1) {
        val fileName = args[0]
        if (fileName.contains("xml")) {
            convertFile(fileName, false)
        } else if (fileName.contains("json")) {
            convertFile(fileName, true)
        } else {
            println("Arg must be an XML or JSON file.")
        }
    } else if (args.size == 3) {
        val word1 = args[0]
        val word2 = args[1]
        val shuffle = args[2]

        val fileName = "output.txt"
        val outputFile = File(fileName)
        val printWriter = PrintWriter(outputFile)

        val shuffleObject = Shuffle()
        val isShuffle = shuffleObject.isShuffle(word1, word2, shuffle)

        if (isShuffle) {
            printWriter.println("CORRECT")
        } else {
            printWriter.println("INCORRECT")
        }

        printWriter.close()
    }
}