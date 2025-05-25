package array

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val baskets = IntArray(n) { it + 1 }

    repeat(m) {
        val (i, j) = readLine()!!.split(" ").map { it.toInt() - 1}
        val temp = baskets[i]
        baskets[i] = baskets[j]
        baskets[j] = temp
    }

    println(baskets.joinToString(" "))
}