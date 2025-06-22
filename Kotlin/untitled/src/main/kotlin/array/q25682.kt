package array

import kotlin.math.min

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val board = Array(n) { readln().toCharArray() }

    val wrongWhenStartW = Array(n) { IntArray(m) }
    val wrongWhenStartB = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            val expectedW = if ((i + j) % 2 == 0) 'W' else 'B'
            val expectedB = if ((i + j) % 2 == 0) 'B' else 'W'

            if (board[i][j] != expectedW) wrongWhenStartW[i][j] = 1
            if (board[i][j] != expectedB) wrongWhenStartB[i][j] = 1
        }
    }

    val prefixSumStartW = Array(n + 1) { IntArray(m + 1) }
    val prefixSumStartB = Array(n + 1) { IntArray(m + 1) }

    for (i in 1 .. n) {
        for (j in 1 .. m) {
            prefixSumStartW[i][j] =
                wrongWhenStartW[i - 1][j - 1] + prefixSumStartW[i - 1][j] + prefixSumStartW[i][j - 1] - prefixSumStartW[i - 1][j - 1]
            prefixSumStartB[i][j] =
                wrongWhenStartB[i - 1][j - 1] + prefixSumStartB[i - 1][j] + prefixSumStartB[i][j - 1] - prefixSumStartB[i - 1][j - 1]
        }
    }

    var result = Int.MAX_VALUE
    for (i in 0.. n - k) {
        for (j in 0..m - k) {
            val expectedStartW =
                prefixSumStartW[i + k][j + k] - prefixSumStartW[i][j + k] - prefixSumStartW[i + k][j] + prefixSumStartW[i][j]
            val expectedStartB =
                prefixSumStartB[i + k][j + k] - prefixSumStartB[i][j + k] - prefixSumStartB[i + k][j] + prefixSumStartB[i][j]

            result = min(result, min(expectedStartW, expectedStartB))
        }
    }
    println(result)
}