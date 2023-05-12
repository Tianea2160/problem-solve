fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }

    val dp = Array(n) { list[0] }
    (1 until n).forEach { idx -> dp[idx] = dp[idx - 1] + list[idx] }

    for (i in 0 until m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        println(dp[b - 1] - dp[a - 1] + list[a - 1])
    }
}