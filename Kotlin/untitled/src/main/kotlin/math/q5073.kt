package math

fun main() {
    val answers = arrayOf("Equilateral", "Isosceles", "Scalene")
    while (true) {
        val numbers = readln().split(" ").map { it.toInt() }
        if (numbers.sum() == 0) break

        val maxLength = numbers.max()
        when {
            numbers.sum() - maxLength <= maxLength -> println("Invalid")
            else -> println(answers[numbers.toSet().size - 1])
        }
    }
}