package array

fun main() {
    val num = readln().toInt()
    val scores = readln().split(' ').map(String::toInt)
    val maxScore = scores.max()
    print(scores.sum() * 100.0 / maxScore / num)
}