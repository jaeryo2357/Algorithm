package dfsbfs

import kotlin.math.min

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val n = reader.readLine().toInt()
    val m = reader.readLine().toInt()

    val board = Array(n) { i -> Array(n) { j -> if (i == j) 0 else Int.MAX_VALUE } }

    repeat(m) {
        val (a, b, c) = reader.readLine().split(" ").map { it.toInt() }
        board[a - 1][b - 1] = min(board[a - 1][b - 1], c)
    }

    repeat(n) { k ->
        repeat(n) { i ->
            repeat(n) { j ->
                board[i][j] = if (board[i][k] != Int.MAX_VALUE && board[k][j] != Int.MAX_VALUE) {
                    min(board[i][j], board[i][k] + board[k][j])
                } else {
                    board[i][j]
                }
            }
        }
    }

    repeat(n) { i ->
        repeat(n) { j ->
            val value = if (board[i][j] == Int.MAX_VALUE) 0 else board[i][j]
            writer.write("$value ")
        }
        writer.write("\n")
    }
    writer.flush()
    writer.close()
}