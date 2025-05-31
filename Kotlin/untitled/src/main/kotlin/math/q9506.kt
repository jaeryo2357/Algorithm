package math

import kotlin.math.sqrt

fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == -1) break

        val divisors = mutableSetOf(1)
        for (number in 2..(sqrt(n.toDouble()).toInt())) {
            if (n % number == 0) {
                divisors.add(number)
                divisors.add(n / number)
            }
        }

        if (divisors.sum() == n) {
            println("$n = ${divisors.sorted().joinToString(" + ")}")
        } else {
            println("$n is NOT perfect.")
        }
    }
}