package priorityqueue

import java.util.PriorityQueue
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val writer = System.out.bufferedWriter()

    val t = scanner.nextInt()
    repeat(t) {
        val m = scanner.nextInt()
        writer.write("${m / 2 + 1}\n")

        val maxQueue = PriorityQueue<Int>(compareByDescending { it })
        val minQueue = PriorityQueue<Int>()

        val numbers = IntArray(m) { scanner.nextInt() }
        var findMiddleCount = 0

        for (index in 0 until m) {
            val num = numbers[index]
            if (maxQueue.isEmpty() || num <= maxQueue.peek()) {
                maxQueue.add(num)
            } else {
                minQueue.add(num)
            }

            if (maxQueue.size < minQueue.size) {
                maxQueue.add(minQueue.poll())
            } else if (maxQueue.size > minQueue.size + 1) {
                minQueue.add(maxQueue.poll())
            }

            if ((index + 1) % 2 == 1) {
                findMiddleCount++
                writer.write("${maxQueue.peek()} ")
                if (findMiddleCount % 10 == 0) writer.write("\n")
            }
        }

        writer.write("\n")
    }

    writer.flush()
    writer.close()
}