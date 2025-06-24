package priorityqueue

import java.util.PriorityQueue
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val k = scanner.nextInt()

    val jewels = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val m = scanner.nextInt()
        val v = scanner.nextInt()
        jewels.add(m to v)
    }
    jewels.sortBy { it.first }

    val bags = IntArray(k) { scanner.nextInt() }
    bags.sort()

    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    var result = 0L
    var jewelIndex = 0

    for (bag in bags) {
        while (jewelIndex < n && jewels[jewelIndex].first <= bag) {
            maxHeap.add(jewels[jewelIndex].second)
            jewelIndex++
        }

        if (maxHeap.isNotEmpty()) {
            result += maxHeap.poll()
        }
    }

    println(result)
}