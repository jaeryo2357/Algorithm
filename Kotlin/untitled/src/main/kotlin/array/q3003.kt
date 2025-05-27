package array

fun main() {
    val requiredPieces = listOf(1, 1, 2, 2, 2, 8)
    val hasPieces = readln().split(" ").map { it.toInt() }

    val result = hasPieces.mapIndexed { index, count -> requiredPieces[index] - count}
    println(result.joinToString(" "))
}