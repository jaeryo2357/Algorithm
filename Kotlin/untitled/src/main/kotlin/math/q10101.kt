package math

fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    when {
        a + b + c != 180 -> println("Error")
        a == 60 && b == 60 && c == 60 -> println("Equilateral")
        a == c || b == c || a == b -> println("Isosceles")
        else -> println("Scalene")
    }
}