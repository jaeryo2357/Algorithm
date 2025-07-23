package dp

fun main() {
    val n = readln().toInt()
    val matrix  = Array(n) { IntArray(2) }

    repeat(n) { index ->
        val (a, b) = readln().split(" ").map { it.toInt() }
        matrix[index][0] = a
        matrix[index][1] = b
    }
    val dp = Array(n) { LongArray(n) { 0L } }

    for (len in 1 until n) {
        for (i in 0 until n - len) {
            val j = i + len
            dp[i][j] = Long.MAX_VALUE
            for (k in i until j) {
                val cost = dp[i][k] + dp[k + 1][j] +
                        matrix[i][0] * matrix[k][1] * matrix[j][1]
                dp[i][j] = minOf(dp[i][j], cost)
            }
        }
    }

    println(dp[0][n - 1])
}