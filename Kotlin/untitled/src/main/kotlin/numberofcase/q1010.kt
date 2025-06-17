package numberofcase

import java.math.BigInteger

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }

        println(combination(m, n))
    }
}

fun factorial(n: Int): BigInteger {
    var result = BigInteger.ONE
    for (i in 2..n) {
        result = result.multiply(BigInteger.valueOf(i.toLong()))
    }
    return result
}

fun combination(n: Int, r: Int): BigInteger {
    return factorial(n) / (factorial(r) * factorial(n - r))
}