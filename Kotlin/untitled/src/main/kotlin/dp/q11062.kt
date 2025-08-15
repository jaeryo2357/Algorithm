package dp

import kotlin.math.max
import kotlin.math.min

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val t = reader.readLine().toInt()
    repeat(t) {
        val n = reader.readLine().toInt()
        val cards = reader.readLine().split(" ").map { it.toInt() }

        val dp = Array(n) { Array(n) { IntArray(2) { -1 } } }

        fun dfs(start: Int, end: Int, turn: Int): Int {
            if (end < start) return 0
            if (dp[start][end][turn] != -1) return dp[start][end][turn]

            val result = if (turn == 0) {
                // 내 턴: 점수 최대화
                max(
                    cards[start] + dfs(start + 1, end, 1),
                    cards[end] + dfs(start, end - 1, 1)
                )
            } else {
                // 상대 턴: 내 점수 최소화
                min(
                    dfs(start + 1, end, 0),
                    dfs(start, end -1, 0)
                )
            }
            dp[start][end][turn] = result
            return result
        }

        writer.write("${dfs(0, n - 1, 0)}\n")
    }

    writer.flush()
    writer.close()
}