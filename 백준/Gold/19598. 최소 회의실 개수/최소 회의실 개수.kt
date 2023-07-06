import java.util.*
import kotlin.math.max

class Work(val start: Long, val end: Long)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val works = (0 until n).map {
        val (a, b) = br.readLine().split(" ").map { it.toLong() }
        Work(a, b)
    }.sortedBy { work -> work.start }
    br.close()

    val queue = PriorityQueue<Long>()
    var answer = 0

    for (work in works) {
        while (queue.isNotEmpty() && queue.peek() <= work.start)
            queue.poll()

        queue.add(work.end)
        answer = max(answer, queue.size)
    }

    println(answer)
}