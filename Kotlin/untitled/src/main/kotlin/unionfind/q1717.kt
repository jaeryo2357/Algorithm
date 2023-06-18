package unionfind

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = reader.readLine().split(" ").map(String::toInt)

    val array = IntArray(n + 1) { it }

    fun findRoot(currentIndex: Int): Int {
        return if (array[currentIndex] == currentIndex) {
            currentIndex
        } else {
            val root = findRoot(array[currentIndex])
            array[currentIndex] = root
            root
        }
    }

    fun union(to: Int, from: Int) {
        //대표 노드를 찾아 연결
        array[findRoot(from)] = findRoot(to)
    }

    repeat(m) {
        val token = StringTokenizer(reader.readLine())
        val action = token.nextToken().toInt()
        val to = token.nextToken().toInt()
        val from = token.nextToken().toInt()

        when (action) {
            0 -> { //합집합
                union(to, from)
            }

            1 -> { //find
                if (findRoot(to) == findRoot(from)) {
                    writer.write("YES\n")
                } else {
                    writer.write("NO\n")
                }
            }
        }
    }

    writer.flush()
    writer.close()
}