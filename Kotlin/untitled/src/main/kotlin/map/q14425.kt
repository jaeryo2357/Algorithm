package map

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val hashMap = hashMapOf<String, Unit>()
    repeat(n) {
        hashMap[readln()] = Unit
    }

    var count = 0
    repeat(m) {
        if (hashMap.containsKey(readln())) count++
    }
    println(count)
}