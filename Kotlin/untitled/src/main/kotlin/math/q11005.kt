package math

fun main() {
    val (n, b) = readln().split(" ").map { it.toInt() }

    fun getChar(number: Int): Char {
        return if (number >= 10) {
            'A' + number - 10
        } else {
            '0' + number
        }
    }

    val stringBuilder = StringBuilder()

    var value = n
    while (value != 0) {
        stringBuilder.insert(0, getChar(value % b))

        value /= b
    }

    println(stringBuilder.toString())
}