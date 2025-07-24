package dp

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val board = Array(n) { readln().split(" ").map { it.toInt() } }
    val dp = Array(n) { Array(m) { -1 } }
    val visit = Array(n) { BooleanArray(m) { false } }

    fun dfs(r: Int, l: Int): Int {
        if (dp[r][l] != -1) return dp[r][l]

        visit[r][l] = true

        val current = board[r][l]
        var result = 0

        if (l + 1 < m && current > board[r][l + 1] && !visit[r][l + 1]) {
            result += dfs(r, l + 1)
        }
        if (r - 1 >= 0 && current > board[r - 1][l] && !visit[r - 1][l]) {
            result += dfs(r - 1, l)
        }

        if (l - 1 >= 0 && current > board[r][l - 1] && !visit[r][l - 1]) {
            result += dfs(r, l - 1)
        }

        if (r + 1 < n && current > board[r + 1][l] && !visit[r + 1][l]) {
            result += dfs(r + 1, l)
        }
        dp[r][l] = result
        visit[r][l] = false

        return dp[r][l]
    }

    dp[n - 1][m - 1] = 1
    dfs(0, 0)

    println(dp[0][0])
}