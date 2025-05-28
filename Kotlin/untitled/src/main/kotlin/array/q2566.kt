package array

fun main() {
    val array = Array(9) {
        readln().split(" ").map { it.toInt() }
    }

    var maxNumber = 0
    var i = 0
    var j = 0

    for ((columnIndex, row) in array.withIndex()) {
        for ((rowIndex, value) in row.withIndex()) {
            if (value > maxNumber) {
                maxNumber = value
                i = columnIndex
                j = rowIndex
            }
        }
    }

    println(maxNumber)
    println("${i + 1} ${j + 1}")
}