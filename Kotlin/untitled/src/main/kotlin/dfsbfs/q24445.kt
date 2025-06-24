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
    val queue = LinkedList<Int>()
    queue.push(r)

    while (queue.isNotEmpty()) {
        val node = queue.pollFirst()
        if (checkBoard[node]) continue
        checkBoard[node] = true
        results[node - 1] = ++visitNodeCount

        for (connectedNode in nodes[node]) {
            if (!checkBoard[connectedNode]) queue.add(connectedNode)
        }
    }

    for (result in results) writer.write("$result\n")
    writer.flush()
    writer.close()
}