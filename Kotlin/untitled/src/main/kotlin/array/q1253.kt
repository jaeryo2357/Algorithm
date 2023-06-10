package array

import java.util.StringTokenizer

fun main() {
    val n: Int = readln().toInt()

    val array = LongArray(n)
    val token = StringTokenizer(readln(), " ")
    repeat(n) {
        array[it] = token.nextToken().toLong()
    }
    array.sort()

    var count = 0

    repeat(n) { kIndex ->
        var startIndex = 0
        var endIndex = n - 1
        val k = array[kIndex]

        while (startIndex < endIndex) {
            when {
                array[startIndex] + array[endIndex] > k -> {
                    endIndex--
                }
                array[startIndex] + array[endIndex] < k -> {
                    startIndex++
                }
                else -> {
                    if (startIndex != kIndex && endIndex != kIndex) {
                        count++
                        break
                    } else if (startIndex == kIndex) {
                        startIndex++
                    } else {
                        endIndex--
                    }
                }
            }
        }
    }
    print(count)
}