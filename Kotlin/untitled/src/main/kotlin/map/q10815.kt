package map

fun main() = with(System.out.bufferedWriter()) {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val numberMap = hashMapOf<Int, Int>()
    for (number in numbers) numberMap[number] = 1

    val m = readln().toInt()
    val ms = readln().split(" ").map { it.toInt() }
    for (value in ms) {
        write("${numberMap.getOrDefault(value, 0)} ")
    }
    close()
}