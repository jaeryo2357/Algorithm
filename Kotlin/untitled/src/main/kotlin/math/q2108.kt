package math

import kotlin.math.roundToInt

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val n = reader.readLine().toInt()
    val numbers = IntArray(n)
    repeat(n) {
        val number = reader.readLine().toInt()
        numbers[it] = number
    }
    val sortedNumbers = numbers.sorted()

    writer.write("${sortedNumbers.average().roundToInt()}\n")
    writer.write("${sortedNumbers[numbers.size / 2]}\n")

    val map = sortedNumbers.groupingBy { it }.eachCount()
    val maxValue = map.maxOf { it.value }
    val final = map.filter { it.value == maxValue }.keys.sorted()

    writer.write("${
        when (final.size) {
            1 -> final.first()
            else -> final[1]
        }
    }\n")
    writer.write("${sortedNumbers.last() - sortedNumbers.first()}")
    writer.close()
}