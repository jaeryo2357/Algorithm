package loop

fun main() {
    val s = readln()
    var isPalindrome = true

    for (index in 0..(s.length / 2)) {
        if (s[index] != s[s.length - index - 1]) {
            isPalindrome = false
        }
    }

    print(if (isPalindrome) 1 else 0)
}