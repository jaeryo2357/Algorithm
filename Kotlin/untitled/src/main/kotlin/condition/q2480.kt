package condition

import kotlin.math.max

fun main() {
    val (num1, num2, num3) = readLine()!!.split(" ").map { it.toInt() }
    when {
        num1 == num2 && num1 == num3 -> print("${10000 + (num1 * 1000)}")
        num1 == num2 -> print("${1000 + (num1 * 100)}")
        num1 == num3 -> print("${1000 + (num1 * 100)}")
        num2 == num3 -> print("${1000 + (num2 * 100)}")
        else -> {
            val maxNum = max(num1, max(num2, num3))
            print("${maxNum * 100}")
        }
    }
}