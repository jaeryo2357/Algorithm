package math

import kotlin.math.sqrt

fun main() {
    val t = readln().toInt()
    repeat(t) {
        var n = readln().toLong()
        while (!isPrime(n)) {
            n++
        }
        println(n)
    }
}

fun isPrime(n: Long): Boolean {
    if (n <= 1L) return false

    for (division in 2..sqrt(n.toDouble()).toLong()) {
        if (n % division == 0L) return false
    }

    return true
}