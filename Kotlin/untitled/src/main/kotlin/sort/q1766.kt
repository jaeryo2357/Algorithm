package sort

import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }

    val lines = Array(n) { LinkedList<Int>() }
    val degrees = IntArray(n)
    val visited = BooleanArray(n)
    val queue = PriorityQueue<Int>()


    repeat(m) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() - 1 }
        lines[a].add(b)
        degrees[b]++
    }

    for (index in 0 until n) {
        if (degrees[index] == 0) {
            visited[index] = true
            queue.add(index)
        }
    }

    while (queue.isNotEmpty()) {
        val currentIndex = queue.poll()
        writer.write("${currentIndex + 1} ")

        lines[currentIndex].forEach { index ->
            degrees[index]--
            if (!visited[index] && degrees[index] == 0) {
                visited[index] = true
                queue.add(index)
            }
        }
    }

    writer.flush()
    writer.close()
}