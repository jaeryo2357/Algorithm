package array

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = reader.readLine().split(" ").map(String::toInt)

    val sumArray = LongArray(n + 1)
    val countArray = LongArray(m)
    val tokens = StringTokenizer(reader.readLine(), " ")
    (1..n).forEach { index ->
        sumArray[index] = sumArray[index - 1] + tokens.nextToken().toLong()
    }
    var answer: Long = 0
    (1..n).forEach { index ->
        val value = (sumArray[index] % m).toInt()
        if (value == 0) answer++
        countArray[value]++
    }

    countArray.forEach {
        if (it > 1) {
            answer += it * (it - 1) / 2
        }
    }
    print(answer)
}