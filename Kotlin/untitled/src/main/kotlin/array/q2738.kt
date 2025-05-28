package array

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arrayA = Array(n) {
        readln().split(" ").map { it.toInt() }
    }
    val arrayB = Array(n) {
        readln().split(" ").map { it.toInt() }
    }
    val result = Array(n) { IntArray(m) }

    repeat(n) { column ->
        repeat(m) { row ->
            result[column][row] = arrayA[column][row] + arrayB[column][row]
        }
    }

    repeat(n) { column ->
        println(result[column].joinToString(" "))
    }
}