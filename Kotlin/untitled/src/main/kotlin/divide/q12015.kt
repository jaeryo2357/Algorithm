package divide

fun main() {
    val n = readln().toInt()
    val array = readln().split(" ").map { it.toInt() }

    val lis = mutableListOf(array[0])
    for (index in 1 until n) {
        if (lis.last() < array[index]) {
            lis.add(array[index])
        } else {
            val lowerBoundIndex = lowerBound(lis, array[index])
            lis[lowerBoundIndex] = array[index]
        }
    }

    println(lis.size)
}

private fun lowerBound(lis: List<Int>, target: Int): Int {
    var left = 0
    var right = lis.size
    while (left < right) {
        val mid = (left + right) / 2
        if (lis[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}