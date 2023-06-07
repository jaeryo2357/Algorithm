package array

fun main() {
    val n = readln().toInt()
    var sum = 1
    var count = 1 // n 하나만 뽑는 경우
    var startValue = 1
    var endValue = 1
    while(startValue != n && endValue != n) {
        when {
            sum > n -> {
                sum -= startValue++
            }
            sum < n -> {
                sum += ++endValue
            }
            else -> {
                count++
                sum += ++endValue
            }
        }
    }
    print(count)
}