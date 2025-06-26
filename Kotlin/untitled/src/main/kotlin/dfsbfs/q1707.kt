package dfsbfs

import java.util.LinkedList

fun main() {
    val k = readln().toInt()
    repeat(k) {
        val (V, E) = readln().split(" ").map { it.toInt() }

        val lines = Array(V) { LinkedList<Int>() }

        repeat(E) {
            val (u, v) = readln().split(" ").map { it.toInt() -1 }
            lines[u].add(v)
            lines[v].add(u)
        }

        println(bfs(V, lines))
    }
}

private fun bfs(
    V: Int,
    lines: Array<LinkedList<Int>>
): String {
    val visited = IntArray(V)
    val queue = LinkedList<Pair<Int, Int>>()

    for (index in 0 until V) {
        if (visited[index] == 0) {
            visited[index] = 1
            queue.add(index to 1)
        }
        while (queue.isNotEmpty()) {
            val (node, value) = queue.pollFirst()
            for (childNode in lines[node]) {
                if (visited[childNode] == 0) {
                    visited[childNode] = if (value == 1) -1 else 1
                    queue.add(childNode to if (value == 1) -1 else 1)
                } else if (visited[childNode] == value) {
                    return "NO"
                }
            }
        }
    }

    return "YES"
}