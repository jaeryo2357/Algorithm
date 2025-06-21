package recursion

private var count = 0

fun mergeSort(
    intArray: IntArray,
    l: Int,
    r: Int,
    k: Int
): Int {
    if (l >= r) return -1
    val q = (l + r) / 2
    val resultOne = mergeSort(intArray, l, q, k)
    if (resultOne != -1) return resultOne
    val resultTwo = mergeSort(intArray, q + 1, r, k)
    if (resultTwo != -1) return resultTwo
    return merge(intArray, l, q, r, k)
}

fun merge(intArray: IntArray, l: Int, q: Int, r: Int, k: Int): Int {
    var i = l
    var j = q + 1
    val sortedIntArray = IntArray(r - l + 1)
    var t = 0

    while (i <= q && j <= r) {
        if (intArray[i] <= intArray[j]) {
            sortedIntArray[t++] = intArray[i++]
        } else {
            sortedIntArray[t++] = intArray[j++]
        }
    }

    while (i <= q) {
        sortedIntArray[t++] = intArray[i++]
    }
    while (j <= r) {
        sortedIntArray[t++] = intArray[j++]
    }
    t = 0
    for (index in l..r) {
        count++
        intArray[index] = sortedIntArray[t++]
        if (count == k) return intArray[index]
    }
    return -1
}

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val array = readln().split(" ").map { it.toInt() }.toIntArray()
    val result = mergeSort(array, 0, n - 1, k)
    println(result)
}
