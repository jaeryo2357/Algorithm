package dynamic

private val map = mutableMapOf<String, Int>()

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()
    while (true) {
        val (a, b, c) = reader.readLine().split(" ").map { it.toInt() }
        if (a == -1 && b == -1 && c == -1) break

        writer.write("w($a, $b, $c) = ${w(a, b, c)}\n")
    }
    writer.close()
}

fun w(a: Int, b: Int, c: Int): Int {
    val key = "$a,$b,$c"
    val result = when {
        a <= 0 || b <= 0 || c <= 0 -> 1

        a > 20 || b > 20 || c > 20 -> w(20, 20, 20)

        map.containsKey(key) -> map[key]!!

        a < b && b < c -> {
            w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        }

        else -> {
            w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        }
    }
    map[key] = result
    return result
}