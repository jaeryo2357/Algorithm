package math

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }
    val gcd = gcd(min(a, b), max(a, b))
    println("${a*b/gcd}")
}

private fun gcd(a: Long, b: Long): Long {
    return if  (b == 0L) a
    else gcd(b,a % b)
}