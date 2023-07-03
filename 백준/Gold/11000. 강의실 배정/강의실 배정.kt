import java.util.PriorityQueue
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val times: Array<Pair<Int, Int>> = Array(n) {
        val nums = br.readLine().split(" ").map { it.toInt() }
        nums[0] to nums[1]
    }
    br.close()

    times.sortBy { time -> time.first } // 시작시간을 기준으로 오름차순

    val queue = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
    var answer = 0

    for (time in times) {
        if (queue.isEmpty()) {
            queue.add(time)
            answer = max(answer, queue.size)
            continue
        }
        val cur = queue.poll()
        queue.add(time)
        if (cur.second > time.first) queue.add(cur)
        answer = max(answer, queue.size)
    }

    println(answer)
}