package array

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.out))
    var tokens = StringTokenizer(bufferedReader.readLine(), " ")
    val n = tokens.nextToken().toInt()
    val l = tokens.nextToken().toInt()
    tokens = StringTokenizer(bufferedReader.readLine(), " ")
    val deque: ArrayDeque<Node> = ArrayDeque(n)

    repeat(n) { index ->
        val now = tokens.nextToken().toInt()

        while (!deque.isEmpty() && deque.last().value > now) {
            deque.removeLast()
        }
        deque.addLast(Node(now, index))

        if (deque.first().index <= index - l) {
            deque.removeFirst()
        }
        bufferedWriter.write("${deque.first().value} ")
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}

class Node(val value: Int, val index: Int)