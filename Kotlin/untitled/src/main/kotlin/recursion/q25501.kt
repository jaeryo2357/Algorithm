package recursion

private var count = 0

fun recursion(s: String, l: Int, r: Int): Int {
    count++
    return if (l >= r) 1
    else if (s[l] != s[r]) 0
    else recursion(s, l + 1, r - 1)
}

fun isPalindrome(s: String): Int {
    return recursion(s, 0, s.length - 1)
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val writer = System.out.bufferedWriter()

    val t = reader.readLine().toInt()
    repeat(t) {
        count = 0
        val s = reader.readLine()
        val result = isPalindrome(s)
        writer.write("$result $count\n")
    }
    writer.close()
}