package sort

fun main() {
    val n = readln().toInt()
    val array = IntArray(n)

    repeat(n) {
        array[it] = readln().toInt()
    }

    for (i in (0 until n)) {
        for (j in (1 until n - i)) {
            val temp = array[j - 1]
            if (array[j] < temp) {
                array[j - 1] = array[j]
                array[j] = temp
            }
        }
    }

    array.forEach {
        println(it)
    }
}