package time

fun main() {
    val n = readln().toLong()
    if (n <= 2L) {
        println(0)
    } else{
        // n, i, j 3(r)개의 수를 뽑는 경우의 수 공식
        // n! / (n - r)! * r!
        println((n - 2) * (n - 1) * n / 6)
    }
    println(3)
}