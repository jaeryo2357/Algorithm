package map

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = hashMapOf<String, Unit>()
    val resultNames = mutableSetOf<String>()
    repeat(n) {
        map[readln()] = Unit
    }
    repeat(m) {
        val input = readln()
        if (map.containsKey(input)) resultNames.add(input)
    }

    write("${resultNames.size}\n")
    for (name in resultNames.sorted()) write("$name\n")

    close()
}