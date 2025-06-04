package time

fun main() {
    val (a1, a0) = readln().split(" ").map { it.toInt() }
    val c = readln().toInt()
    val n0 = readln().toInt()

    if ((a1 - c) * n0 + a0 <= 0 && c >= a1) {
        println("1")
    } else {
        println("0")
    }
}