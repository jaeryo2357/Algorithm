package math

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val number = readln().toInt()

        println(
            "${number / 25} ${(number % 25) / 10} ${(number % 25 % 10) / 5} ${number % 25 % 10 % 5}"
        )
    }
}