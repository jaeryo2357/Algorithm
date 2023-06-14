package stack

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

/**
 * 버퍼가 일정량 이상되면 비정기적으로 flush가 되기 때문에 출력값 형태가 결과에 따라 다른 경우 사용하면 안됨
 */

fun main() {
    val stack = Stack<Int>()
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = StringBuffer("")
    val n = reader.readLine().toInt()

    var currentNumber = 0

    for (i in (0 until n)) {
        val currentN = reader.readLine().toInt()

        when {
            stack.isEmpty() || stack.peek() < currentN -> {
                (currentNumber + 1 .. currentN).forEach {
                    writer.append("+\n")
                    stack.push(it)
                }
                // 마지막 값은 뺴주기
                writer.append("-\n")
                stack.pop()
                currentNumber = currentN
            }

            stack.peek() == currentN -> {
                writer.append("-\n")
                stack.pop()
            }

            else -> {
                print("NO")
                return
            }
        }
    }

    print(writer.toString())
}