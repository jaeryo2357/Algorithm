package twopoint

import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()

    val primeNumbers = getPrimes(n)
    var result = 0

    var sum = primeNumbers.getOrNull(0) ?: 0
    var l = 0
    var r = 0

    while (l < primeNumbers.size) {
        when {
            sum == n -> {
                sum -= primeNumbers[l++]
                result++
            }

            sum < n && r + 1 < primeNumbers.size -> {
                r += 1
                sum += primeNumbers.getOrNull(r) ?: 0
            }

            else -> {
                sum -= primeNumbers[l++]
            }
        }
    }


    println(result)
}

private fun getPrimes(n: Int): List<Int> {
    if (n < 2) return emptyList()

    val isPrime  = BooleanArray(n + 1) { true }
    isPrime [0] = false
    isPrime [1] = false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (isPrime [i]) {
            for (j in i + i .. n step i) {
                isPrime [j] = false
            }
        }
    }

    val primeNumbers = mutableListOf<Int>()
    for (i in 2..n) {
        if (isPrime[i]) primeNumbers.add(i)
    }
    return primeNumbers
}