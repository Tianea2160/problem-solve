import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toLong() }.toLongArray()
    
    // 첫 k일 동안의 온도 합으로 answer 초기화
    var answer = (0 until k).sumOf { arr[it] }
    var cur = answer

    for (i in k until n) {
        cur -= arr[i - k]
        cur += arr[i]
        answer = max(cur, answer)
    }

    println(answer)
    br.close()
}
