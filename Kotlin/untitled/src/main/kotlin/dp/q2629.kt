package dp

import kotlin.math.abs

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val n = reader.readLine().toInt()
    val sinkers = reader.readLine().split(" ").map { it.toInt() }
    val t = reader.readLine().toInt()
    val targets = reader.readLine().split(" ").map { it.toInt() }

    val total = sinkers.sum()
    val maxDiff = total

    // dp[i][d]: i개까지 고려했을 때 차이 d를 만들 수 있는가
    val dp = Array(n + 1) { BooleanArray(maxDiff + 1) { false } }
    dp[0][0] = true

    for (i in 0 until n) {
        for (diff in 0..maxDiff) {
            if (!dp[i][diff]) continue
            // 1. 사용하지 않음
            dp[i + 1][diff] = true
            // 2. 추를 더해서 차이 증가
            val add = diff + sinkers[i]
            if (add <= maxDiff) dp[i + 1][add] = true
            // 3. 추를 반대쪽에 올려서 차이 줄이거나 절댓값
            val sub = abs(diff - sinkers[i])
            if (sub <= maxDiff) dp[i + 1][sub] = true
        }
    }

    for (target in targets) {
        if (target > maxDiff) {
            writer.write("N ")
        } else {
            writer.write(if (dp[n][target]) "Y " else "N ")
        }
    }

    writer.flush()
    writer.close()
}