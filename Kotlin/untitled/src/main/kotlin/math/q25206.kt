package math

fun main() {
    val number = 20
    var totalGrade = 0f
    var totalScore = 0f
    repeat(number) {
        val (_, grade, rank) = readln().split(" ")
        if (rank != "P") {
            totalGrade += grade.toFloat()
            totalScore += convertRankToScore(rank) * grade.toFloat()
        }
    }
    println(totalScore / totalGrade)
}

private fun convertRankToScore(grade: String): Float {
    return when (grade) {
        "A+" -> 4.5f
        "A0" -> 4.0f
        "B+" -> 3.5f
        "B0" -> 3.0f
        "C+" -> 2.5f
        "C0" -> 2.0f
        "D+" -> 1.5f
        "D0" -> 1.0f
        "F" -> 0.0f
        else -> 0.0f
    }
}