package map

fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()
    val map = mutableMapOf<String, Unit>()
    var result = 0
    repeat(n) {
        val s = reader.readLine()
        if (s == "ENTER") {
            map.clear()
        } else {
            if (!map.containsKey(s)) {
                map.put(s, Unit)
                result++
            }
        }
    }
    println(result)
}