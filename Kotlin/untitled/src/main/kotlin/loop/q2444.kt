package loop

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val repeatCount = 2 * n - 1
    repeat(repeatCount) { column ->
        val starBeginIndex = abs(n - column - 1)
        val startEndIndex = repeatCount - abs(n - column - 1)
        for (index in 0 until starBeginIndex) print(" ")
        for (index in starBeginIndex until startEndIndex) print("*")
        println()
    }
}