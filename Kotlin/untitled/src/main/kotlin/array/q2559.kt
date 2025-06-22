package array

import kotlin.math.max

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val temperatures = readln().split(" ").map { it.toInt() }

    var maxTemperature = temperatures.subList(0, k).sum()
    var currentTemperature = maxTemperature
    for (index in 0 until n - k) {
        currentTemperature = currentTemperature - temperatures[index] + temperatures[k + index]
        maxTemperature = max(maxTemperature, currentTemperature)
    }

    println(maxTemperature)
}