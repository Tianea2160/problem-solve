import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = IntArray(n) { readln().toInt() }

    nums.sort()

    var answer = Int.MAX_VALUE

    for (i in nums.indices) {
        for (j in i..nums.lastIndex) {
            val cur = nums[j] - nums[i]
            if (cur >= m){
                answer = min(answer, nums[j] - nums[i])
                break
            }
        }
    }

    println(answer)
}