import org.junit.Assert.*
import org.junit.Test

class ADSUnitTests {

    @Test
    fun testXMLConversion() {
        val fileConverter = XMLJSONConverter()
        val schemaPath = "ab_schema.xsd"
        val xmlPath = "ab.xml"

        fileConverter.convertFile(xmlPath, false)
        fileConverter.convertFile("converted.json", true)

        assertTrue(fileConverter.validateXmlAgainstSchema("converted.xml", schemaPath))
    }

    @Test
    fun testShuffle() {
        val shuffle = Shuffle()
        val word1 = "TOURNAMENT"
        val word2 = "DINNER"

        var isShuffle = shuffle.isShuffle(word1, word2, "TOUINN")
        assertFalse(isShuffle)

        isShuffle = shuffle.isShuffle(word1, word2, "TOUDINN")
        assertTrue(isShuffle)

        isShuffle = shuffle.isShuffle(word1, word2, "TDINOURNANMENTER")
        assertTrue(isShuffle)

        isShuffle = shuffle.isShuffle(word1, word2, "DINTOUR")
        assertTrue(isShuffle)

        isShuffle = shuffle.isShuffle(word1, "DETOUR", "DETOURTO")
        assertTrue(isShuffle)
    }
}