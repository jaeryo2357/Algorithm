package twopoint

import kotlin.math.abs

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val n = reader.readLine().toInt()
    val array = reader.readLine().split(" ").map { it.toInt() }.sorted()

    var min = Int.MAX_VALUE
    var result = ""
    var l = 0
    var r = n - 1

    while (l < r) {
        val sum = array[l] + array[r]
        when {
            abs(sum) < min -> {
                result = "${array[l]} ${array[r]}"
                min = abs(sum)
            }

            sum > 0 -> {
                r--
            }

            else -> l++
        }
    }


    writer.write(result)

    writer.flush()
    writer.close()
}