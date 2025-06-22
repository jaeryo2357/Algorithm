package dynamic

import kotlin.math.max

private val dp = Array(10001) { IntArray(3) { -1 } }

fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val wines = IntArray(n) { reader.readLine().toInt() }

    println(drink(wines, n - 1, 2))
}

private fun drink(wines: IntArray, index: Int, availableCount: Int): Int {
    when {
        dp[index][availableCount] != -1 -> return dp[index][availableCount]
        index == 0 -> {
            dp[index][availableCount] = if (availableCount > 0)  wines[index] else 0
        }
        availableCount > 0 -> {
            dp[index][availableCount] = max(
                wines[index] + drink(wines, index - 1, availableCount - 1),
                drink(wines, index - 1, 2)
            )
        }
        else -> {
            dp[index][availableCount] = drink(wines, index - 1, 2)
        }
    }
    return dp[index][availableCount]
}