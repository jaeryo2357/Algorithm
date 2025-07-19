package twopoint

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val n = reader.readLine().toInt()
    val array = reader.readLine().split(" ").map { it.toInt() }.sorted()
    val x = reader.readLine().toInt()

    var l = 0
    var r = n - 1

    var result = 0
    while (l < r) {
        val sum = array[l] + array[r]
        when {
            sum == x -> {
                result++
                l++
                r--
            }

            sum < x -> l++
            else -> r--
        }
    }

    writer.write("$result")

    writer.flush()
    writer.close()
}