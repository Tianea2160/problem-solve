import kotlin.math.max

fun main() {
    val (n, d, k, c) = readln().split(" ").map { it.toInt() }
    val nums = Array(n) { readln().toInt() }
    val map = mutableMapOf<Int, Int>()
    for (i in 0 until k) map[nums[i]] = (map[nums[i]] ?: 0) + 1
    var result = map.size

    for (i in k until 2 * n) {
        val prev = (i-k) % n
        val next = i % n

        map[nums[prev]] = (map[nums[prev]] ?: 0) - 1
        if (map[nums[prev]] == 0) map.remove(nums[prev])
        map[nums[next]] = (map[nums[next]] ?: 0) + 1

        val count = if(c in map) map.size else map.size + 1
        result = max(result, count)
    }

    println(result)
}