package math

fun main() {
    val n = readln().toInt()
    val array = IntArray(n) { readln().toInt() }

    var gcd = array[1] - array[0]
    for (index in 1 until array.size - 1) {
        gcd = gcd(gcd, array[index + 1] - array[index])
    }
    var count = 0

    for (index in 0 until array.size - 1) count += (array[index + 1] - array[index]) / gcd - 1
    println(count)
}

private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) return a
    else gcd(b, a % b)
}