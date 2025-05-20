package condition

fun main() {
    val (hour, time) = readLine()!!.split(" ").map { it.toInt() }
    val cookTime = readln().toInt()

    val maxMinutes = 24 * 60
    val targetMinutes = (hour * 60 + time + cookTime) % maxMinutes

    print("${targetMinutes / 60} ${targetMinutes % 60}")
}