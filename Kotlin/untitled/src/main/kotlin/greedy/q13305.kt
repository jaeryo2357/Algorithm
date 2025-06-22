package greedy

fun main() {
    val n = readln().toInt()
    val roads = readln().split(" ").map { it.toLong() }
    val oils = readln().split(" ").map { it.toLong() }

    var result = roads[0] * oils[0]
    var minOils = oils[0]
    for (index in 1 until n - 1) {
        if (minOils > oils[index]) {
            minOils = oils[index]
        }
        result += roads[index] * minOils
    }

    println(result)
}