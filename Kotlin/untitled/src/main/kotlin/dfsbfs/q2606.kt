package dfsbfs

import java.util.*

fun main() {
    val computers = readln().toInt()
    val lines = readln().toInt()

    val nodes = Array(computers + 1) { LinkedList<Int>() }

    repeat(lines) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        nodes[u].add(v)
        nodes[v].add(u)
    }
    val checkBoard = BooleanArray(computers + 1)

    val queue = LinkedList<Int>()
    queue.push(1)

    while (queue.isNotEmpty()) {
        val node = queue.pollFirst()
        if (checkBoard[node]) continue
        checkBoard[node] = true

        for (connectedNode in nodes[node]) {
            if (!checkBoard[connectedNode]) queue.add(connectedNode)
        }
    }
    val result = checkBoard.sumOf { if (it) 1L else 0 } - 1
    println(result)
}