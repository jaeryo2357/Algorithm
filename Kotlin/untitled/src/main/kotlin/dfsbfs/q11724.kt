package dfsbfs

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = reader.readLine().split(" ").map(String::toInt)

    //노드의 인덱스가 1부터 시작
    val array = Array(n + 1) { ArrayList<Int>() }
    val visited = Array(n + 1) { false }

    repeat(m) {
        val (i, j) = reader.readLine().split(" ").map(String::toInt)
        array[i].add(j)
        array[j].add(i)
    }

    fun dfs(currentIndex: Int) {
        if (visited[currentIndex]) return
        visited[currentIndex] = true
        array[currentIndex].forEach {
            if (!visited[it]) {
                dfs(it)
            }
        }
    }

    var count = 0
    (1..n).forEach {
        if (!visited[it]) {
            dfs(it)
            count++
        }
    }

    print(count)
}