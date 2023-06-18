import java.lang.Integer.max
import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val graph = Array(n + 1) { ArrayList<Int>() }
    val times = IntArray(n + 1)
    val count = IntArray(n + 1)
    val result = IntArray(n + 1)

    (1..n).forEach {
        val tokens = StringTokenizer(readln(), " ")
        times[it] = tokens.nextToken().toInt()

        var nextValue = tokens.nextToken().toInt()
        while (nextValue != -1) {
            graph[nextValue].add(it)
            count[it]++
            nextValue = tokens.nextToken().toInt()
        }
    }

    val queue = LinkedList<Int>()
    (1..n).forEach {
        if (count[it] == 0) {
            queue.offer(it)
        }
    }

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        graph[now].forEach {
            count[it]--
            result[it] = max(result[it], result[now] + times[now]) //?

            if (count[it] == 0) {
                queue.offer(it)
            }
        }
    }

    (1 .. n).forEach {
        println(result[it] + times[it])
    }
}
