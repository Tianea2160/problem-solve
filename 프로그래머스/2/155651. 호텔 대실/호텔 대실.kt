import java.util.PriorityQueue
import kotlin.math.max

class Solution {
    fun solution(times: Array<Array<String>>): Int {
        var answer = 0
        val rooms = PriorityQueue<Int> { a, b -> a - b }
        val sortedTimes = times.map { (a, b) -> convertTimeToMinutes(a) to convertTimeToMinutes(b) }.sortedBy { it.first }

        for (time in sortedTimes) {
            val (start, end) = time

            if (rooms.isNotEmpty() && rooms.peek() <= start) {
                rooms.poll()
            }

            rooms.add(end + 10)
            answer = max(answer, rooms.size)
        }

        return answer
    }

    private fun convertTimeToMinutes(time: String): Int {
        val (hour, min) = time.split(":").map { it.toInt() }
        return hour * 60 + min
    }
}