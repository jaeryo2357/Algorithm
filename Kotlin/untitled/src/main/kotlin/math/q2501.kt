package math

import kotlin.math.sqrt

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var number = mutableSetOf<Int>(1, n)

    for (divisor in 2..(sqrt(n.toDouble()).toInt())) {
        if (n % divisor == 0) {
            number.add(divisor)
            number.add(n / divisor)
        }
    }

    println(number.sorted().getOrNull(k - 1) ?: 0)
}