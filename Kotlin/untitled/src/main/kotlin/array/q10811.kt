package array

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val baskets = IntArray(n) { it + 1 }

    repeat(m) {
        val (i, j) = readLine()!!.split(" ").map { it.toInt() - 1 }
        var leftIndex = i
        var rightIndex = j

        while (leftIndex < rightIndex) {
            val temp = baskets[leftIndex]
            baskets[leftIndex] = baskets[rightIndex]
            baskets[rightIndex] = temp
            leftIndex++
            rightIndex--
        }
    }

    println(baskets.joinToString(" "))
}