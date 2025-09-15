package dp

fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val array = reader.readLine().split(" ").map { it.toInt() }

    val lis = mutableListOf<Int>()
    val pos = IntArray(n)

    for (i in array.indices) {
        val x = array[i]
        var idx = lis.binarySearch(x)
        if (idx < 0) idx = -(idx + 1)

        if (idx == lis.size) {
            lis.add(x)
        } else {
            lis[idx] = x
        }
        pos[i] = idx
    }

    println(lis.size)

    val result = IntArray(lis.size)
    var k = lis.size - 1
    for (i in n - 1 downTo 0) {
        if (pos[i] == k) {
            result[k] = array[i]
            k--
        }
        if (k < 0) break
    }
    println(result.joinToString(" "))
}