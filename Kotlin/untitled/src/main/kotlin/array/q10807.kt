package array

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val targetNumber = readLine()!!.toInt()

    var count = 0
    for (number in numbers) {
        if (number == targetNumber) count++
    }

    println(count)
}