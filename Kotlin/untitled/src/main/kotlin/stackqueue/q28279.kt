package stackqueue

import java.util.*

fun main() {
    val n = readln().toInt()
    val stack = LinkedList<Int>()
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    repeat(n) {
        val input = reader.readLine().split(" ")

        when (input[0]) {
            "1" -> stack.addFirst(input[1].toInt())
            "2" -> stack.addLast(input[1].toInt())
            "3" -> {
                val result =  stack.pollFirst() ?: -1
                writer.write("$result\n")
            }
            "4" -> {
                val result = stack.pollLast() ?: -1
                writer.write("$result\n")
            }
            "5" -> writer.write("${stack.size}\n")
            "6" -> writer.write(if (stack.isEmpty()) "1\n" else "0\n")
            "7" -> {
                val result = stack.peekFirst() ?: -1
                writer.write("$result\n")
            }
            "8" -> {
                val result = stack.peekLast() ?: -1
                writer.write("$result\n")
            }
        }
    }
    writer.close()
}