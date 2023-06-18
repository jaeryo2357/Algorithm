package graph

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (v, e) = reader.readLine().split(" ").map(String::toInt)
    val start = reader.readLine().toInt()

    val graph = Array(v + 1) { ArrayList<Edge>() }

    repeat(e) {
        val tokens = StringTokenizer(reader.readLine(), " ")
        val to = tokens.nextToken().toInt()
        val from = tokens.nextToken().toInt()
        val w = tokens.nextToken().toInt()

        graph[to].add(Edge(from, w))
    }

    val visited = Array<Boolean>(v + 1) { false}
    val result = IntArray(v + 1) { Int.MAX_VALUE }
    val queue = PriorityQueue<Edge>().apply {
        offer(Edge(start, 0))
    }

    result[start] = 0

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        if (visited[now.index]) continue
        visited[now.index] = true

        graph[now.index].forEach {
            if (result[it.index] > result[now.index] + it.value) {
                result[it.index] = result[now.index] + it.value
                queue.offer(Edge(it.index, result[it.index]))
            }
        }
    }

    (1..v).forEach {
        if (visited[it]) {
            writer.write("${result[it]}\n")
        } else {
            writer.write("INF\n")
        }
    }

    writer.flush()
    writer.close()
}

class Edge(
    val index: Int,
    val value: Int
): Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return if (this.value > other.value) 1
        else -1
    }
}