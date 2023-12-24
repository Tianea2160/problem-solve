import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    val queue = PriorityQueue<Int>()

    for (i in 0 until t) {
        val num = br.readLine().toInt()
        if (num == 0) {
            val min = queue.poll() ?: 0
            bw.write(min.toString())
            bw.newLine()
        } else {
            queue.add(num)
        }
    }

    bw.close()
    br.close()
}