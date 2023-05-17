import java.io.File
import java.io.PrintWriter

fun main(args: Array<String>) {
    if (args.size == 1) {
        //val fileConverter = XMLJSONConverter()
        val fileName = args[0]
        if (fileName.contains("\\.xml")) {

        } else if (fileName.contains("\\.json")) {

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
    println("Program arguments: ${args.joinToString()}")

}