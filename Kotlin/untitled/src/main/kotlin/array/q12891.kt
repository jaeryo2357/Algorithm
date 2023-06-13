package array

import java.util.StringTokenizer

fun main() {
    val dnas = listOf('A', 'C', 'G', 'T')
    val (length, k) = readln().split(" ").map(String::toInt)
    val s = readln()
    val tokens = StringTokenizer(readln(), " ")
    val needCount = IntArray(4)
    val currentCount = IntArray(4)

    repeat(4) {
        needCount[it] = tokens.nextToken().toInt()
    }

    repeat(k) {
        // 초기 윈도우 count 세기
        currentCount[dnas.indexOf(s[it])]++
    }

    var startIndex = 0
    var endIndex = k - 1
    var count = 0

    while (endIndex < length) {
        var isAvailable = true
        repeat(4) {
            if (needCount[it] > currentCount[it]) {
                isAvailable = false
            }
        }

        if (isAvailable) {
            count++
        }

        // 윈도우 이동
        currentCount[dnas.indexOf(s[startIndex++])]--
        endIndex++
        if (endIndex >= length) break
        currentCount[dnas.indexOf(s[endIndex])]++
    }
    print(count)
}