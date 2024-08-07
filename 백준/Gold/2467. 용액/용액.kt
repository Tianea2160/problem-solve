import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    var (left, right) = 0 to n - 1
    val nums = br.readLine().split(" ").map { it.toLong() }.toLongArray()
    var answer = -1 to -1
    var min = Long.MAX_VALUE

    while (left < right) {
        val sum = nums[left] + nums[right]

        if (abs(sum) < min) {
            min = abs(sum)
            answer = left to right
        }

        if (sum > 0) {
            right--
        } else if (sum == 0L) {
            break
        } else {
            left++
        }
    }

    bw.write("${nums[answer.first]} ${nums[answer.second]}")
    bw.flush()
    bw.close()
    br.close()
}