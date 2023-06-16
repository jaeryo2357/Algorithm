package greedy

import java.lang.StringBuilder
import java.util.*

fun main() {
    val str = readln()
    val stack = Stack<String>()

    var numberString = StringBuilder()
    str.forEach { char ->
        if (char.isDigit()) { //숫자
            numberString.append(char)
        } else {
            val number = numberString.toString()
            numberString = StringBuilder()

            stack.push(
                if (stack.isNotEmpty() && stack.peek().startsWith("-")) {
                    "-$number"
                } else {
                    number
                }
            )

            if (char == '-') {
                stack.push("-0")
            }
        }
    }

    if (numberString.isNotEmpty()) {
        stack.push(
            if (stack.isNotEmpty() && stack.peek().startsWith("-")) {
                "-$numberString"
            } else {
                numberString.toString()
            }
        )
    }


    var result = 0
    while (stack.isNotEmpty()) {
        result += stack.pop().toInt()
    }

    print(result)
}