fun main() {
    val (n, x) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toLong() }

    var sum: Long = (0 until x).sumOf { idx -> nums[idx] }
    var max = sum
    var cnt = 1

    for (i in x until  n) {
        sum += nums[i]
        sum -= nums[i - x]
        if (max < sum) {
            max = sum
            cnt = 1
        } else if (max == sum) {
            cnt++
        }
    }

    if (sum == 0L) {
        println("SAD")
    } else {
        println(max)
        println(cnt)
    }
}