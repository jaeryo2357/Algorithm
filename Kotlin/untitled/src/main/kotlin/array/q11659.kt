package array

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val (num, queries) = reader.readLine().split(" ").map(String::toInt)

    val sumArray = LongArray(num + 1)
    val tokens = StringTokenizer(reader.readLine(), " ")
    (1..num).forEach { index ->
        sumArray[index] = sumArray[index - 1] + tokens.nextToken().toInt()
    }
    val buffer = StringBuffer()
    repeat(queries) {
        val (i, j) = reader.readLine().split(" ").map(String::toInt)
        buffer.append(sumArray[j] - sumArray[i - 1]).append("\n")
    }
    print(buffer)
}