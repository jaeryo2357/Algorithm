package recursion

import java.util.*
import kotlin.math.pow

fun main() {
    val sc = Scanner(System.`in`)
    val writer = System.out.bufferedWriter()

    while (sc.hasNextInt()) {
        val n = sc.nextInt()
        val array = BooleanArray(3.0.pow(n).toInt()) { true }
        cantor(array, 0, array.size - 1)
        val result = array.joinToString("") { if (it) "-" else " " }
        writer.write("$result\n")
    }
    writer.close()
}

fun cantor(array: BooleanArray, l: Int, r: Int) {
    if (l >= r) return
    val division = (r - l + 1) / 3
    cantor(array, l, l + division - 1)
    for (index in l + division .. r - division) {
        array[index] = false
    }
    cantor(array, r - division + 1, r)
}