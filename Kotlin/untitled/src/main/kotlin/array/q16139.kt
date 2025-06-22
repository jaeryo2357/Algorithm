package array

private const val charSize = 'z' - 'a' + 1
fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val s = reader.readLine()

    val array = Array(s.length + 1) { IntArray(charSize)}

    for (i in 1..s.length) {
        val c = s[i - 1]
        for (j in 0 until charSize) {
            array[i][j] = array[i - 1][j] + if (c - 'a' == j) 1 else 0
        }
    }

    val q = reader.readLine().toInt()
    repeat(q) {
        val (c, l, r) = reader.readLine().split(" ")
        val findChar = c[0] - 'a'
        val start = l.toInt() + 1
        val end = r.toInt() + 1
        writer.write("${array[end][findChar] - array[start - 1][findChar]}\n")
    }
    writer.close()
}