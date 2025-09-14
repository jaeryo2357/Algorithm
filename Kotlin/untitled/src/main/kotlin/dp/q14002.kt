package dp

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(n) { 1 }
    val parent = IntArray(n) { -1 }

    var maxLen = 1
    var maxIdx = 0

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1
                parent[i] = j
            }
        }
        if (dp[i] > maxLen) {
            maxLen = dp[i]
            maxIdx = i
        }
    }

    val lis = mutableListOf<Int>()
    var cur = maxIdx
    while (cur != -1) {
        lis.add(arr[cur])
        cur = parent[cur]
    }
    lis.reverse()

    println(maxLen)
    println(lis.joinToString(" "))
}