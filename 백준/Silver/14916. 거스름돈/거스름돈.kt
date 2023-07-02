import kotlin.math.min

fun main() {
    val n = readln().toInt()
    var answer = Int.MAX_VALUE
    val visit = BooleanArray(100001) { false }

    fun recur(cur: Int, count: Int) {
        if (answer < count) return
        if (cur == n) {
            answer = min(answer, count)
        } else if (cur > n) {
            return
        }
        if (cur + 5 <= n && !visit[cur + 5]) {
            visit[cur + 5] = true
            recur(cur + 5, count + 1)
        }

        if (cur + 2 <= n && !visit[cur + 2]) {
            visit[cur + 2] = true
            recur(cur + 2, count + 1)
        }
    }
    visit[0] = true
    recur(0, 0)
    answer = if(answer == Int.MAX_VALUE) -1 else answer
    println(answer)
}