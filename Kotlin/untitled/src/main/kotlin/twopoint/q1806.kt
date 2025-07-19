package twopoint

import kotlin.math.min

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val (n, s) = reader.readLine().split(" ").map { it.toInt() }
    val array = reader.readLine().split(" ").map { it.toInt() }

    var result = Int.MAX_VALUE
    var sum = array[0]
    var l = 0
    var r = 0

    while (l < n) {
        when {
            sum >= s -> {
                result = min(result, r - l + 1)
                sum -= array[l]
                l++
            }
            r + 1 < n -> {
                r++
                sum += array[r]
            }
            else -> {
                sum -= array[l]
                l++
            }
        }
    }

    writer.write("${if (result == Int.MAX_VALUE) 0 else result}")

    writer.flush()
    writer.close()
}