package math

import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    val point = 2.0.pow(n) + 1
    println(point.pow(2).toInt())
}