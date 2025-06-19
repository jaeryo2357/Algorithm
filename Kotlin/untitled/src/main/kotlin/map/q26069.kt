package map

fun main() {
    val reader = System.`in`.bufferedReader()
    val n = reader.readLine().toInt()

    val dancingPerson = hashMapOf<String, Unit>("ChongChong" to Unit)

    repeat(n) {
        val (a, b) = reader.readLine().split(" ")
        val isDancingA = dancingPerson.containsKey(a)
        val isDancingB = dancingPerson.containsKey(b)
        if (isDancingA || isDancingB) {
            dancingPerson[a] = Unit
            dancingPerson[b] = Unit
        }
    }

    println(dancingPerson.size)
}