package dfsbfs

import java.util.PriorityQueue


fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val values = IntArray(100001) { Int.MAX_VALUE }
    values[n] = 0

    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    queue.add(n to 0)

    while (queue.isNotEmpty()) {
        val (tempN, tempK) = queue.poll()
        if (tempN - 1 >= 0 && values[tempN - 1] > tempK + 1) {
            values[tempN - 1] = tempK + 1
            queue.add(tempN - 1 to tempK + 1)
        }
        if (tempN + 1 <= 100000 && values[tempN + 1] > tempK + 1) {
            values[tempN + 1] = tempK + 1
            queue.add(tempN + 1 to tempK + 1)
        }
        if (tempN * 2 <= 100000 && values[tempN * 2] > tempK) {
            values[tempN * 2] = tempK
            queue.add(tempN * 2 to tempK)
        }
    }

    println(values[k])
}