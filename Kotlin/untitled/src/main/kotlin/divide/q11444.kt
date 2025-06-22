package divide

private const val MOD = 1_000_000_007L

fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
    return arrayOf(
        longArrayOf(
            (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD,
            (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD,
        ),
        longArrayOf(
            (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD,
            (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD
        )
    )
}

fun power(matrix: Array<LongArray>, n: Long): Array<LongArray> {
    if (n == 1L) return matrix
    val half = power(matrix, n / 2)
    val result = multiply(half, half)
    return if (n % 2 == 0L) result else multiply(result, matrix)
}

fun main() {
    val n = readln().toLong()

    val base = arrayOf(
        longArrayOf(1, 1),
        longArrayOf(1, 0)
    )

    val result = power(base, n)
    println((result[0][1]) % MOD)
}