package search

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val array = IntArray(n)

    var tokens = StringTokenizer(readln(), " ")
    repeat(n) {
        array[it] = tokens.nextToken().toInt()
    }
    array.sort()

    fun binarySearch(target: Int, startIndex: Int, endIndex: Int): Int {
        if (startIndex > endIndex) return 0

        val centerIndex = (endIndex + startIndex) / 2
        return when {
            target == array[centerIndex] -> 1
            target > array[centerIndex] -> {
                binarySearch(target, centerIndex + 1, endIndex)
            }
            else -> {
                binarySearch(target, startIndex, centerIndex - 1)
            }
        }
    }

    val m = readln().toInt()
    tokens = StringTokenizer(readln(), " ")

    repeat(m) {
        val target = tokens.nextToken().toInt()
        println(binarySearch(target, 0, n - 1))
    }
}