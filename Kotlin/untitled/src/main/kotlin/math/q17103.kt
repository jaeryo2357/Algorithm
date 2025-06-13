package math

import kotlin.math.sqrt

private val map = HashMap<Int, Boolean>()

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        var result = 0
        for (i in 2..(n/2)) {
            if (isPrime(i) && isPrime(n - i)) {
                result++
            }
        }
        println(result)
    }
}

fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    if (map.contains(n)) return map[n]!!

    for (division in 2..sqrt(n.toDouble()).toInt()) {
        if (n % division == 0) {
            map[n] = false
            return false
        }
    }

    map[n] = true
    return true
}