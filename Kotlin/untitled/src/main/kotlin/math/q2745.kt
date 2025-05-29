package math

import kotlin.math.pow

fun main() {
    val (n, b) = readln().split(" ")
    var result = 0

    fun getNumber(char: Char): Int {
        return if (char in 'A'..'Z') 10 + (char - 'A')
        else char - '0'
    }

    for (index in n.length - 1 downTo  0) {
        result += getNumber(n[index]) * (b.toDouble().pow(n.length - 1 - index).toInt())
    }

    println(result)
}