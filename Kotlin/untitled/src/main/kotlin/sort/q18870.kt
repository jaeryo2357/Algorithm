package sort

fun main() = with(System.out.bufferedWriter()) {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val sortedNumbers = numbers.distinct().sorted()

    for (number in numbers) {
        write("${sortedNumbers.binarySearch(number)} ")
    }

    close()
}