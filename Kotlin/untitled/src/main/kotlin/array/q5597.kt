package array

fun main() {
    val checkBoard = BooleanArray(30)
    repeat(28) {
        val submitIndex = readLine()!!.toInt() - 1
        checkBoard[submitIndex] = true
    }

    for (index in 0 until 30) {
        if (!checkBoard[index]) println(index + 1)
    }
}