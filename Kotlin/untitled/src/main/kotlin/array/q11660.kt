package array

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val (n, queries) = reader.readLine().split(" ").map(String::toInt)

    val board = Array(n + 1) { LongArray(n + 1) }
    (1..n).forEach { i ->
        val tokens = StringTokenizer(reader.readLine(), " ")
        (1..n).forEach { j ->
            board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + tokens.nextToken().toInt()
        }
    }

    val buffer = StringBuffer()
    repeat(queries) {
        val tokens = StringTokenizer(reader.readLine(), " ")
        val x1 = tokens.nextToken().toInt()
        val y1 = tokens.nextToken().toInt()
        val x2 = tokens.nextToken().toInt()
        val y2 = tokens.nextToken().toInt()

        buffer.append(board[x2][y2] - (board[x1 - 1][y2] + board[x2][y1 - 1]) + board[x1 - 1][y1 - 1])
            .append("\n")
    }
    println(buffer)
}