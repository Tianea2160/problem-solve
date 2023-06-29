fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }

    var result = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (nums[i] + nums[j] == m) result++
        }
    }
    println(result)
}