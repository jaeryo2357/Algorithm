package dp

fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 1)
    val prev = IntArray(n + 1)

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        prev[i] = i - 1

        if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
            dp[i] = dp[i / 2] + 1
            prev[i] = i / 2
        }
        if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
            dp[i] = dp[i / 3] + 1
            prev[i] = i / 3
        }
    }

    println(dp[n])

    var cur = n
    val path = mutableListOf<Int>()
    while (cur != 0) {
        path.add(cur)
        if (cur == 1) break
        cur = prev[cur]
    }
    println(path.joinToString(" "))
}