package dp

import kotlin.math.max

fun main() {
    val reader = System.`in`.bufferedReader()

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val memories = reader.readLine().split(" ").map { it.toInt() }
    val costs = reader.readLine().split(" ").map { it.toInt() }

    val maxCost = costs.sum()
    val dp = IntArray(maxCost + 1) { 0 }

    for (i in 0 until n) {
        val cost = costs[i]
        val memory = memories[i]

        for (c in maxCost downTo cost) {
            dp[c] = max(dp[c], dp[c - cost] + memory)
        }
    }

    var answer = Int.MAX_VALUE
    for (c in 0..maxCost) {
        if (dp[c] >= m) {
            answer = c
            break
        }
    }

    println(answer)
}