package array

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val baskets = IntArray(n)

    repeat(m) {
        val (i, j, k) = readLine()!!.split(" ").map { it.toInt() }
        for (index in (i - 1) until j) {
            baskets[index] = k
        }
    }

    println(baskets.joinToString(" "))
}