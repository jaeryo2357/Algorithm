package array

fun main() {
    val board = Array(100) { BooleanArray(100) }
    val n = readln().toInt()

    repeat(n) {
        val (i, j) = readln().split(" ").map { it.toInt() }
        for (startRowIndex in i until i + 10) {
            for (startColumIndex in j until j + 10) {
                board[startColumIndex][startRowIndex] = true
            }
        }
    }

    var sum = 0
    repeat(100) { i ->
        repeat(100) { j ->
            sum += if (board[i][j]) 1 else 0
        }
    }

    println(sum)
}