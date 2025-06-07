package map

fun main() = with(System.out.bufferedWriter()) {
    val n = readln().toInt()
    val company = hashMapOf<String, Unit>()
    repeat(n) {
        val (name, status) = readln().split(" ")
        if (status == "enter") company[name] = Unit
        else company.remove(name)
    }

    for (existName in company.keys.sortedDescending()) write("$existName\n")

    close()
}