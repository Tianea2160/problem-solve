import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val x = LongArray(size = n + 1) { 0 }
    val y = LongArray(size = n + 1) { 0 }

    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toLong() }
        x[i] = a
        y[i] = b
    }

    x[n] = x[0]
    y[n] = y[0]
    var sumA = 0L
    var sumB = 0L

    for (i in 0 until n) {
        sumA += (x[i] * y[i + 1])
        sumB += (x[i + 1] * y[i])
    }
    print("%.1f".format(abs(sumA - sumB) / 2.0))
    br.close()
}