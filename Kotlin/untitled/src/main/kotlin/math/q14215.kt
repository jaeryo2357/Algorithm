package math

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    val maxLength = numbers.max()
    val totalLength = numbers.sum()
    val diff = totalLength - maxLength
    if (diff > maxLength) {
        println(totalLength)
    } else {
        println(totalLength - (maxLength - diff + 1))
    }
}