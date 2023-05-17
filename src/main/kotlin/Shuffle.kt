class Shuffle {
    fun isShuffle(word1: String, word2: String, shuffle: String): Boolean {
        var i = 0
        var j = 0

        for (k in shuffle.indices) {
            if (i < word1.length && shuffle[k] == word1[i]) {
                i++
            } else if (j < word2.length && shuffle[k] == word2[j]) {
                j++
            } else {
                return false
            }
        }

        return true
    }
}