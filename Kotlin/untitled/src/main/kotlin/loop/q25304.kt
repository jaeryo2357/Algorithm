package loop

fun main() {
    val x = readLine()!!.toInt()
    val n = readLine()!!.toInt()

    var totalPrice = 0
    repeat(n) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        totalPrice += a * b
    }
    print(if (totalPrice == x) "Yes" else "No")
}