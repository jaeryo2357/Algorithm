package map

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val poketMonMapKeyIsName = hashMapOf<String, Int>()
    val poketMonMapKeyIsNumber = hashMapOf<Int, String>()

    repeat(n) { index ->
        val name = readln()
        poketMonMapKeyIsName[name] = index + 1
        poketMonMapKeyIsNumber[index + 1] = name
    }

    repeat(m) {
        val input = readln()
        val convertedNumber = input.toIntOrNull()
        if (convertedNumber != null) {
            write("${poketMonMapKeyIsNumber[convertedNumber]}\n")
        } else {
            write("${poketMonMapKeyIsName[input]}\n")
        }
    }

    close()
}