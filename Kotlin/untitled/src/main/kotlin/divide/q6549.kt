package divide

import java.util.LinkedList
import java.util.Scanner
import kotlin.math.max

fun main() {
    val scanner = Scanner(System.`in`)
    val writer = System.out.bufferedWriter()
    while (true) {
        val n = scanner.nextInt()
        if (n == 0) break

        val squares = IntArray(n) { scanner.nextInt() }
        val stack = LinkedList<Int>()
        stack.push(0)

        var result = 0L
        for (index in 1 until n) {
            while (stack.isNotEmpty() && squares[stack.peek()] > squares[index]) {
                val endIndex = stack.pop()
                val height = squares[endIndex]
                val width = if (stack.isEmpty()) index else index - stack.peek() - 1
                result = max(result, height * width.toLong())
            }
            stack.push(index)
        }

        while (stack.isNotEmpty()) {
            val index = stack.pop()
            val height = squares[index]
            val width = if (stack.isEmpty()) n else n - stack.peek() - 1
            result = max(result, height * width.toLong())
        }

        writer.write("$result\n")
    }

    writer.flush()
    writer.close()
}