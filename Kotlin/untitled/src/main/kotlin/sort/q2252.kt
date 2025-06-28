package sort

import java.util.LinkedList

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }

    val visited = BooleanArray(n)
    val lines = Array(n) { LinkedList<Int>() }
    val degrees = IntArray(n)

    repeat(m) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() - 1 }
        degrees[b]++
        lines[a].add(b)
    }

    val queue = LinkedList<Int>()
    degrees.forEachIndexed { index, degree ->
        if (degree <= 0) {
            visited[index] = true
            queue.add(index)
        }
    }

    while (queue.isNotEmpty()) {
        val node = queue.pollFirst()
        writer.write("${node + 1} ")

        lines[node].forEach {
            degrees[it]--
            if (degrees[it] <= 0 && !visited[it]) {
                visited[it] = true
                queue.add(it)
            }
        }
    }

    writer.flush()
    writer.close()
}