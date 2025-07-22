package twopoint

fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }

    val leftNums = nums.subList(0, n / 2)
    val rightNums = nums.subList(n / 2, n)

    fun getSubset(list: List<Int>): List<Long> {
        val subset = mutableListOf<Long>()
        fun dfs(index: Int, current: Long) {
            if (index == list.size) {
                subset.add(current)
                return
            }

            dfs(index + 1, current)
            dfs(index + 1, current + list[index])
        }
        dfs(0, 0)
        return subset
    }

    val leftSum = getSubset(leftNums)
    val rightSum = getSubset(rightNums).sorted()

    var result = 0L

    for (l in leftSum) {
        val remain = c - l
        val count = upperBound(rightSum, remain)
        result += count
    }

    println(result)
}

private fun upperBound(list: List<Long>, target: Long): Int {
    var low = 0
    var high = list.size

    while (low < high) {
        val mid = (low + high) / 2
        if (list[mid] <= target) {
            low = mid + 1
        } else {
            high = mid
        }
    }

    return low
}