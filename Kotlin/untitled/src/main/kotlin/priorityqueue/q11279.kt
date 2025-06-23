package priorityqueue

import java.util.PriorityQueue

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val n = reader.readLine().toInt()
    val priorityQueue = PriorityQueue<Int>(n) { o1, o2 ->
        o2 - o1
    }
    repeat(n) {
        val input = reader.readLine().toInt()
        if (input == 0) {
            writer.write("${priorityQueue.poll() ?: 0}\n")
        } else {
            priorityQueue.add(input)
        }
    }

    writer.flush()
    writer.close()
}