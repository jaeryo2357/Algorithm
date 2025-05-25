package word

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val s = readln()
        println("${s.first()}${s.last()}")
    }
}