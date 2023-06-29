import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    val x = br.readLine().toInt()

    var (left, right) = 0 to nums.lastIndex
    var result = 0
    while (left != right) {
        val cur = nums[left] + nums[right]
        if (cur == x) {
            result++
            right--
        } else {
            if (cur < x) {
                left++
            } else {
                right--
            }
        }
    }
    println(result)
}