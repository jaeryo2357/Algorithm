package stackqueue

import java.util.LinkedList

fun main() = with(System.out.bufferedWriter()) {
    val n = readln().toInt()
    val dequeue = LinkedList<Int>()
    val flags = readln().split(" ")
    val initNumbers = readln().split(" ").map { it.toInt() }
    for (index in 0 until n) {
        if (flags[index] == "1") continue
        dequeue.addLast(initNumbers[index])
    }

    val m = readln().toInt()
    val inputNumbers = readln().split(" ").map { it.toInt() }
    for (number in inputNumbers) {
        dequeue.addFirst(number)
        write("${dequeue.pollLast()} ")
    }
    close()
}