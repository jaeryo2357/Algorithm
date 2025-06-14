package stack

import java.util.Stack

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    val stack = Stack<Int>()

    var nextNeedNumber = 1
    for (number in numbers) {
        if (nextNeedNumber == number) {
            nextNeedNumber++
        }

        while (!stack.isEmpty() && stack.peek() == nextNeedNumber) {
            stack.pop()
            nextNeedNumber++
        }

        if (nextNeedNumber < number) {
            stack.add(number)
        }
    }

    while (!stack.isEmpty()) {
        val topNumber = stack.pop()
        if (nextNeedNumber == topNumber) nextNeedNumber++
        else break
    }

    if (stack.isEmpty()) {
        println("Nice")
    } else {
        println("Sad")
    }
}