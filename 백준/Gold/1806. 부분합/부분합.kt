fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, s) = br.readLine().split(" ").map { it.toLong() }
    val arr = LongArray(size = (n + 1).toInt()) { 0 }

    br.readLine().split(" ").map { it.toLong() }.forEachIndexed { idx, value -> arr[idx] = value }

    var (left, right) = 0 to 0
    var sum: Long = 0
    var answer = Int.MAX_VALUE

    while (left <= n && right <= n) {
        if (sum >= s && answer > right - left) answer = right - left
        when {
            sum < s -> sum += arr[right++]
            sum >= s -> sum -= arr[left++]
        }
    }
    answer = if (answer == Int.MAX_VALUE) 0 else answer

    bw.write("$answer")
    bw.close()
    br.close()
}