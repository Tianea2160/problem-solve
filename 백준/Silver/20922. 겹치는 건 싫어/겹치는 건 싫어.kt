import kotlin.math.max

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }
    // 빈도수를 체크하는 배열 선언
    val visit = IntArray(100001) { 0 }
    var answer = 1
    var s = 0

    for (e in 0 until n) {
        // 끝 포인터의 값이 k와 같으면 앞쪽 포인터의 위치를 당겨온다.
        while (visit[nums[e]] == k) visit[nums[s++]]--

        // 끝쪽 포인터 값을 하나 늘린다.
        visit[nums[e]]++
        answer = max(answer, e - s + 1)
    }
    println("$answer")
}