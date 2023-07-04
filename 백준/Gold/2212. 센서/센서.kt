fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val sensers = br.readLine().split(" ").map { it.toInt() }.sorted()
    br.close()
    var answer = 0
    val gaps = (1 until sensers.size).map { i -> sensers[i] - sensers[i - 1] }.sortedDescending()
    // 수신 가능 영역 범위의 최소값을 찾아라 -> 센서들 사이의 차이 중에서 k-1개의 값만 가져라 -> 탐욕법
    for (i in k - 1 until gaps.size) answer += gaps[i]
    println(answer)
}