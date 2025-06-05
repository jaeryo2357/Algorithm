package sort

fun main() {
    val numbers = IntArray(5) { readln().toInt() }
    println("${numbers.sum() / numbers.size}")
    println("${numbers.sorted().let { it[it.size / 2] }}")
}