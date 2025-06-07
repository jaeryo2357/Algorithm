package map

fun main() {
    val ab = readln()
    val aMap = hashMapOf<String, Unit>()
    val bMap = hashMapOf<String, Unit>()

    for (an in readln().split(" ")) {
        aMap[an] = Unit
    }
    for (bn in readln().split(" ")) {
        bMap[bn] = Unit
    }

    val count = aMap.filterKeys { !bMap.containsKey(it) }.count() +
            bMap.filterKeys { !aMap.containsKey(it) }.count()
    println(count)
}