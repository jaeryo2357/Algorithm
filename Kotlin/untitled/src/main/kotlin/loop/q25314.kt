package loop

fun main() {
    val stringBuffer = StringBuffer()
    val n = readLine()!!.toInt()
    val repeatCount = n / 4 + if (n % 4 > 0) 1 else 0
    repeat(repeatCount) {
        stringBuffer.append("long ")
    }
    stringBuffer.append("int")
    println(stringBuffer.toString())
}