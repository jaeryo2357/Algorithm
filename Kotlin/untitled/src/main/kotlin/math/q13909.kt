package math

import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    var result = 0
    for (i in 1..sqrt(n.toDouble()).toInt()) result++
    println(result)
}