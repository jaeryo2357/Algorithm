package input

fun main() {
    val num = readlnOrNull()?.split(" ")?.map { it.toLong() }?.reduce { a, n -> a + n  } ?: 0
    print("$num")
}