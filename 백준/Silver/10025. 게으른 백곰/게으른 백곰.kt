import kotlin.math.max

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val maps = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        val (g, x) = readln().split(" ").map { it.toInt() }
        maps[x] = g
    }
    var sum = (0 ..2 * k).sumOf { i -> maps.getOrDefault(i, 0) }
    var result = sum
    for (i in k+1..1_000_000) {
        sum += (maps[i + k] ?: 0)
        sum -= (maps[i - k - 1] ?: 0)
        result = max(result, sum)
    }
    println(result)
}