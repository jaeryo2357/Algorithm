package recursion

fun main() {
    val n = readln().toLong()
    println(factorial(n))
}

fun factorial(n: Long) : Long {
    return if (n <= 1) 1L
    else n * factorial(n - 1)
}