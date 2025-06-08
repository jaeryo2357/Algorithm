package map

fun main() = with(System.out.bufferedWriter()) {
    val t = readln().toInt()
    repeat(t) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        val gcd = gcd(a, b)
        write("${a*b/gcd}\n")
    }
    close()
}

fun gcd(a: Int, b: Int): Int {
    return if  (b == 0) a
    else gcd(b,a % b)
}