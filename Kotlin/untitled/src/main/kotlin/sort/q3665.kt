package sort

import java.util.LinkedList

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val t = reader.readLine().toInt()
    repeat(t) {
        val n = reader.readLine().toInt()
        val lastGrades = reader.readLine().split(" ").map { it.toInt() - 1 }

        val lines = Array(n) { mutableSetOf<Int>() }
        val degrees = IntArray(n)

        // 작년 순위를 기반으로 그래프 구성 (상위 → 하위)
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                lines[lastGrades[i]].add(lastGrades[j])
                degrees[lastGrades[j]]++
            }
        }

        // 올해 순위 변경 처리
        val m = reader.readLine().toInt()
        repeat(m) {
            val (aRaw, bRaw) = reader.readLine().split(" ").map { it.toInt() - 1 }

            if (lines[aRaw].contains(bRaw)) {
                lines[aRaw].remove(bRaw)
                degrees[bRaw]--
                lines[bRaw].add(aRaw)
                degrees[aRaw]++
            } else {
                lines[bRaw].remove(aRaw)
                degrees[aRaw]--
                lines[aRaw].add(bRaw)
                degrees[bRaw]++
            }
        }

        // 위상 정렬
        val queue = LinkedList<Int>()
        val result = mutableListOf<Int>()
        val visited = BooleanArray(n)
        var uncertain = false

        for (i in 0 until n) {
            if (degrees[i] == 0) {
                queue.add(i)
                visited[i] = true
            }
        }

        while (queue.isNotEmpty()) {
            // 동시 처리 가능한 정점이 2개 이상 → 순위 불확실
            if (queue.size > 1) uncertain = true

            val current = queue.poll()
            result.add(current)

            for (next in lines[current]) {
                degrees[next]--
                if (degrees[next] == 0 && !visited[next]) {
                    visited[next] = true
                    queue.add(next)
                }
            }
        }

        // 출력
        when {
            result.size != n -> writer.write("IMPOSSIBLE\n") // 사이클 존재
            uncertain -> writer.write("?\n")                 // 유일하지 않음
            else -> writer.write(result.joinToString(" ") { (it + 1).toString() } + "\n")
        }
    }

    writer.flush()
    writer.close()
}