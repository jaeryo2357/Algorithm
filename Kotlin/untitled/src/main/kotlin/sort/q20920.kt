package sort

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val countMap = mutableMapOf<String, Int>()
    repeat(n) {
        val s = reader.readLine()
        if (s.length >= m) {
            countMap[s] = (countMap[s] ?: 0) + 1
        }
    }
    val words = countMap.keys.map { EnglishWord(it, countMap[it]!!) }
        .sorted()

    for (word in words) writer.write("$word\n")
    writer.close()
}

class EnglishWord(
    private val word: String,
    private val count: Int
): Comparable<EnglishWord> {
    override fun compareTo(other: EnglishWord): Int {
        return if (count != other.count) {
            other.count - count
        } else if (word.length != other.word.length) {
            other.word.length - word.length
        } else {
            word.compareTo(other.word)
        }
    }

    override fun toString(): String {
        return word
    }
}