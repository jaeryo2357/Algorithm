package dynamic

private var countOne = 0
private var countTwo = 0

fun main() {
    val n = readln().toInt()
    fib(n)
    fibonacci(n)
    println("$countOne $countTwo")
}

fun fib(n: Int): Int {
    return if (n == 1 || n == 2) {
        countOne++
        1
    }
    else fib(n - 1) + fib(n - 2)
}

fun fibonacci(n: Int) {
    val array = IntArray(n + 1)
    array[1] = 1
    array[2] = 1

    for (index in 3..n) {
        countTwo++
        array[index] = array[index - 1] + array[index - 2]
    }
}