package dfsbfs

import java.lang.StringBuilder

fun main() {
    val (n, m, startNode) = readln().split(" ").map(String::toInt)
    val graph = Array(n + 1) { ArrayList<Int>() }

    repeat(m) {
        val (i, j) = readln().split(" ").map(String::toInt)
        graph[i].add(j)
        graph[j].add(i)
    }

    repeat(n + 1) {
        graph[it].sort()
    }

    var result = StringBuilder()
    var visited = Array<Boolean>(n + 1) { false }
    fun dfs(currentNode: Int) {
        if (visited[currentNode]) return
        visited[currentNode] = true
        result.append("$currentNode ")

        graph[currentNode].forEach {
            dfs(it)
        }
    }

    dfs(startNode)
    println(result)

    visited = Array(n + 1) { false }
    result = StringBuilder()
    fun bfs(currentNode: Int) {
        val queue = ArrayDeque<Int>(n + 1).apply {
            addLast(currentNode)
        }

        while (queue.isNotEmpty()) {
            val topNode = queue.removeFirst()
            if (visited[topNode]) continue

            visited[topNode] = true
            result.append("$topNode ")

            graph[topNode].forEach {
                if (!visited[it]) {
                    queue.addLast(it)
                }
            }
        }
    }

    bfs(startNode)
    println(result)
}