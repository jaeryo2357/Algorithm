package dfsbfs

import java.util.LinkedList

val visited = BooleanArray(100)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val array = IntArray(100) { it }

    repeat(n + k) {
        val (u, v) = readln().split(" ").map { it.toInt() - 1 }
        array[u] = v
    }

    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(0 to 0)
    visited[0] = true

    var result = 100
    while (queue.isNotEmpty()) {
        val (num, roll) = queue.pollFirst()
        val moveNum = array[num]
        if (moveNum >= 99) {
            result = roll
            break
        }

        for (r in 1..6) {
            val next = moveNum + r
            if (next <= 99 && !visited[array[next]]) {
                visited[array[next]] = true
                queue.add(array[next] to roll + 1)
            }
        }
    }

    println(result)
}