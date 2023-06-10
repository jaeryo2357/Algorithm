package array

import java.util.StringTokenizer

fun main() {
    val n: Int = readln().toInt()
    val m: Int = readln().toInt()

    val array = LongArray(n)
    val token = StringTokenizer(readln(), " ")
    repeat(n) {
        array[it] = token.nextToken().toLong()
    }
    array.sort()

    var startIndex = 0
    var endIndex = n - 1
    var count = 0

    while (startIndex < endIndex) {
        when {
            array[startIndex] + array[endIndex] > m -> {
                endIndex--
            }
            array[startIndex] + array[endIndex] < m -> {
                startIndex++
            }
            else -> {
                count++
                startIndex++
                endIndex--
            }
        }
    }
    print(count)
}