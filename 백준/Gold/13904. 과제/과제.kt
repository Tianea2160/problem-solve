import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val works = (0 until n).map {
        val (d, w) = br.readLine().split(" ").map { it.toInt() }
        d to w
    }

    var answer = 0
    val done = BooleanArray(works.maxOf { it.first } + 1) { false }
    val queue = PriorityQueue<Pair<Int, Int>> { a, b -> b.second - a.second }
    for (work in works) queue.add(work)

    while (queue.isNotEmpty()) {
        val work = queue.poll()
        var day = work.first

        while (day > 0) {
            if (!done[day]) {
                done[day] = true
                answer += work.second
                break
            }
            day--
        }
    }

    println(answer)
}