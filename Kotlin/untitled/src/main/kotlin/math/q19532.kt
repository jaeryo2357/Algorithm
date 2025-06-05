package math

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }

    for (x in -999..999) {
        for (y in -999..999) {
            if (
                numbers[0] * x + numbers[1] * y == numbers[2] &&
                numbers[3] * x + numbers[4] * y == numbers[5]
                ) {
                println("$x $y")
                return
            }
        }
    }
}