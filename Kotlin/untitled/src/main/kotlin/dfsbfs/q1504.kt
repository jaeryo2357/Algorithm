package dfsbfs

import java.util.LinkedList
import java.util.PriorityQueue

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val (n, e) = reader.readLine().split(" ").map { it.toInt() }
    val lines = Array(n) { LinkedList<Pair<Int, Int>>() }

    repeat(e) {
        val (a, b, c) = reader.readLine().split(" ").map { it.toInt() }
        lines[a - 1].add((b - 1) to c)
        lines[b - 1].add((a - 1) to c)
    }
    val (v1, v2) = reader.readLine().split(" ").map { it.toInt() - 1 }

    val a1 = dijkstra(0, v1, lines)
    val a2 = dijkstra(v1, v2, lines)
    val a3 = dijkstra(v2, n - 1, lines)

    val b1 = dijkstra(0, v2, lines)
    val b2 = dijkstra(v2, v1, lines)
    val b3 = dijkstra(v1, n - 1, lines)

    val path1 = if (a1 == Int.MAX_VALUE || a2 == Int.MAX_VALUE || a3 == Int.MAX_VALUE) Int.MAX_VALUE else a1 + a2 + a3
    val path2 = if (b1 == Int.MAX_VALUE || b2 == Int.MAX_VALUE || b3 == Int.MAX_VALUE) Int.MAX_VALUE else b1 + b2 + b3

    val answer = minOf(path1, path2)
    writer.write("${if (answer == Int.MAX_VALUE) -1 else answer}\n")
    writer.flush()
    writer.close()
}

private fun dijkstra(
    start: Int,
    end: Int,
    lines: Array<LinkedList<Pair<Int, Int>>>
): Int {
    val minValues = IntArray(lines.size) { Int.MAX_VALUE }
    minValues[start] = 0

    val heap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    heap.add(start to 0)

    while (heap.isNotEmpty()) {
        val (point, value) = heap.poll()
        lines[point].forEach { (p, v) ->
            if (minValues[p] > value + v) {
                minValues[p] = value + v
                heap.add(p to (value + v))
            }
        }
    }

    return minValues[end]
}