package array

import kotlin.math.max

fun main() {
    val strings = Array(5) { "" }
    var maxLength = 0
    repeat(strings.size) { index ->
        strings[index] = readln()
        maxLength = max(maxLength, strings[index].length)
    }

    val stringBuilder = StringBuilder()
    repeat(maxLength) { readIndex ->
        repeat(strings.size) { stringIndex ->
            strings[stringIndex].getOrNull(readIndex)?.let { stringBuilder.append(it) }
        }
    }

    println(stringBuilder.toString())
}