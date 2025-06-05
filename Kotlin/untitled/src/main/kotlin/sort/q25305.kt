package sort

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val grades = readln().split(" ").map { it.toInt() }
    println(grades.sortedDescending().take(k).last())
}