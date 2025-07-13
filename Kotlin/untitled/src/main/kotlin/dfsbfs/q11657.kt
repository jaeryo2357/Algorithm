package dfsbfs


fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val line = mutableListOf<Triple<Int, Int, Int>>()
    repeat(m) {
        val (a, b, c) = reader.readLine().split(" ").map { it.toInt() }
        line.add(Triple(a - 1, b - 1, c))
    }

    val distance = LongArray(n) { Long.MAX_VALUE }
    distance[0] = 0

    fun bellmanFord(): Boolean {
        repeat(n) { v ->
            line.forEach { (a, b, c) ->
                if (distance[a] != Long.MAX_VALUE && distance[b] > distance[a] + c) {
                    distance[b] = distance[a] + c
                    if (v == n - 1) return true
                }
            }
        }
        return false
    }

    if (bellmanFord()) {
        writer.write("-1")
    } else {
        for (i in 1 until n) {
            if (distance[i] != Long.MAX_VALUE) {
                writer.write("${distance[i]}\n")
            } else {
                writer.write("-1\n")
            }
        }
    }

    writer.flush()
    writer.close()
}