package math

import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    var minX = Int.MAX_VALUE
    var maxX = Int.MIN_VALUE
    var minY = Int.MAX_VALUE
    var maxY = Int.MIN_VALUE

    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        minX = min(x, minX)
        maxX = max(x, maxX)
        minY = min(y, minY)
        maxY = max(y, maxY)
    }

    println((maxX - minX) * (maxY - minY))
}