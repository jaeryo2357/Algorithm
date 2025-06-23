package priorityqueue

import java.util.PriorityQueue
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val priorityQueue = PriorityQueue<Int>() { o1, o2 ->
        o2 - o1
    }
    repeat(n * n) {
        priorityQueue.add(scanner.nextInt())
    }

    repeat(n - 1) {
        priorityQueue.poll()
    }

    println(priorityQueue.peek())
}