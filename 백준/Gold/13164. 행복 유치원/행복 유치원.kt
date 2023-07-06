fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val heights = br.readLine().split(" ").map { it.toInt() }
    br.close()
    val diffs = (0 until heights.size - 1).map { i -> heights[i + 1] - heights[i] }.sorted()

    var answer = 0
    for (i in 0 until n - k) {
        answer += diffs[i]
    }

    println(answer)
}