package prime

import kotlin.math.sqrt

fun main() {
    val (m, n) = readln().split(" ").map(String::toInt)
    val primeNumbers = Array<Boolean>(n + 1) { true }
    primeNumbers[1] = false
    (2.. sqrt(n.toDouble()).toInt()).forEach { number ->
        if (primeNumbers[number]) {
            var temp = number + number
            while (temp <= n) {
                primeNumbers[temp] = false
                temp += number
            }
        }
    }

    (m..n).forEach { number ->
        if (primeNumbers[number]) println(number)
    }
}