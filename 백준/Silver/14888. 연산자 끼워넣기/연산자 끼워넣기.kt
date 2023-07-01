import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    fun readln(): String = br.readLine()
    val n = readln().toInt()

    val nums = readln().split(" ").map { it.toInt() }.toIntArray()
    val opers = readln().split(" ").map { it.toInt() }.toIntArray()

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    fun recur(opers: IntArray, nums: IntArray, cur: Int, idx: Int) {
        if (idx == n) {
            max = max(max, cur)
            min = min(min, cur)
            return
        }
        for (i in 0 until 4) {
            if (opers[i] > 0) {
                opers[i]--
                when (i) {
                    0 -> recur(opers, nums, cur + nums[idx], idx + 1)
                    1 -> recur(opers, nums, cur - nums[idx], idx + 1)
                    2 -> recur(opers, nums, cur * nums[idx], idx + 1)
                    3 -> recur(opers, nums, cur / nums[idx], idx + 1)
                }
                opers[i]++
            }
        }
    }

    recur(opers, nums, nums[0], 1)
    bw.write("$max\n$min")
    br.close()
    bw.close()
}