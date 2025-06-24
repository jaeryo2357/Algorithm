package dfsbfs

import java.util.LinkedList

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val (n, m, r) = reader.readLine().split(" ").map { it.toInt() }
    val nodes = Array(n + 1) { LinkedList<Int>() }
    repeat(m) {
        val (u, v) = reader.readLine().split(" ").map { it.toInt() }
        nodes[u].add(v)
        nodes[v].add(u)
    }
    val checkBoard = BooleanArray(n + 1)
    var visitNodeCount = 0

    for (i in 1..n) {
        nodes[i].sortDescending()
    }

    val results = IntArray(n)
    fun dfs(node: Int) {
        if (checkBoard[node]) return
        checkBoard[node] = true
        results[node - 1] = ++visitNodeCount

        for (connectedNode in nodes[node]) {
            dfs(connectedNode)
        }
    }

    dfs(r)

    for (result in results) writer.write("$result\n")
    writer.flush()
    writer.close()
}