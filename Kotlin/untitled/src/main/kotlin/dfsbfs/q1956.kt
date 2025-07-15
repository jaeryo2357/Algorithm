package dfsbfs

import kotlin.math.min

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val (V, E) = reader.readLine().split(" ").map { it.toInt() }

    val board = Array(V) { Array(V) { Int.MAX_VALUE } }
    repeat(E) {
        val (a, b, c) = reader.readLine().split(" ").map { it.toInt() }
        board[a - 1][b - 1] = c
    }

    repeat(V) { k ->
        repeat(V) { i ->
            repeat(V) { j ->
                if (board[i][k] != Int.MAX_VALUE && board[k][j] != Int.MAX_VALUE) {
                    board[i][j] = min(board[i][j], board[i][k] + board[k][j])
                }
            }
        }
    }

    var min = Int.MAX_VALUE
    repeat(V) { i ->
        min = min(min, board[i][i])
    }

    writer.write("${if (min == Int.MAX_VALUE) -1 else min}")

    writer.flush()
    writer.close()
}