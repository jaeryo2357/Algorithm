package dfsbfs

import java.util.*

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val T = reader.readLine().toInt()
    repeat(T) {
        val (n, m, t) = reader.readLine().split(" ").map { it.toInt() }
        val (s, g, h) = reader.readLine().split(" ").map { it.toInt() - 1 }

        val lines = Array(n) { mutableListOf<Pair<Int, Int>>() }
        repeat(m) {
            val (a, b, d) = reader.readLine().split(" ").map { it.toInt() }
            lines[a - 1].add((b - 1) to d)
            lines[b - 1].add((a - 1) to d)
        }

        val candidates = Array(t) { reader.readLine().toInt() - 1 }.sorted()

        val origin = dijkstra(s, lines)
        val atH = dijkstra(h, lines)
        val atG = dijkstra(g, lines)

        candidates.forEach {
            if (
                origin[it] >= (origin[h] + atH[g] + atG[it]) ||
                origin[it] >= (origin[g] + atG[h] + atH[it])
            ) {
                writer.write("${it + 1} ")
            }
        }
        writer.write("\n")
    }
    writer.flush()
    writer.close()
}

private fun dijkstra(
    start: Int,
    lines: Array<MutableList<Pair<Int, Int>>>
): IntArray {
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

    return minValues
}