package math

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (a1, b1) = readln().split(" ").map { it.toInt() }
    val (a2, b2) = readln().split(" ").map { it.toInt() }

    var gcd = gcd(b1, b2)
    val resultA = (a1 * b2 + a2 * b1) / gcd
    val resultB = (b1 * b2) / gcd

    gcd = gcd(min(resultA, resultB), max(resultA, resultB))
    if (gcd == 1) {
        println("$resultA $resultB")
    } else {
        println("${resultA / gcd} ${resultB / gcd}")
    }
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) return a
    else gcd(b, a % b)
}