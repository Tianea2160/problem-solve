import kotlin.math.min

fun main() {
    var count = 1
    while (true) {
        val (l, p, v) = readln().split(" ").map { it.toInt() }
        if (l == 0) break
        val share = v / p
        val mod = v % p
        println("Case ${count++}: ${share * l + min(mod, l)}")
    }
}