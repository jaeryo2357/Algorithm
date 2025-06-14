package stack

import java.util.EmptyStackException
import java.util.Stack

fun main() {
    val n = readln().toInt()
    val stack = Stack<Int>()
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    repeat(n) {
        val input = reader.readLine().split(" ")

        when (input[0]) {
            "1" -> stack.add(input[1].toInt())
            "2" -> {
                val result = try {
                    stack.pop()
                } catch (e: EmptyStackException) {
                    -1
                }
                writer.write("$result\n")
            }
            "3" -> writer.write("${stack.size}\n")
            "4" -> writer.write(if (stack.isEmpty()) "1\n" else "0\n")
            "5" -> {
                val result = try {
                    stack.peek()
                } catch (e: EmptyStackException) {
                    -1
                }
                writer.write("$result\n")
            }
        }
    }
    writer.close()
}