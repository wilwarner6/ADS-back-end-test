import org.junit.Test
import org.junit.Assert.*

class ADSUnitTests {

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