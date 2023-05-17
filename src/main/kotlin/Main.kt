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
    if (args.size == 0) {
        println("Args must be supplied")
        return
    }
    val function = args[0]

    if (function.equals("AddressBook") && args.size >= 2) {
        val fileName = args[1]
        if (fileName.contains("xml")) {
            convertFile(fileName, false)
        } else if (fileName.contains("json")) {
            convertFile(fileName, true)
        } else {
            println("Arg must be an XML or JSON file.")
        }
    } else if (function.equals("Shuffle") && args.size >= 4) {
        val word1 = args[1]
        val word2 = args[2]
        val shuffle = args[3]

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