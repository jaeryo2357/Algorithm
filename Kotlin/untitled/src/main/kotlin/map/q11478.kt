package map

fun main() {
    val s = readln()
    val sMap = hashMapOf<String, Unit>()

    for (i in s.indices) {
        for (j in i .. s.length) {
            val partialS = s.substring(i, j)
            if (partialS.isNotEmpty() && !sMap.containsKey(partialS)) {
                sMap[partialS] = Unit
            }
        }
    }

    println(sMap.size)
}