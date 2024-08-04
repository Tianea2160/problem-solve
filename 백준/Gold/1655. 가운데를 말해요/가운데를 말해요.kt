import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val leftQueue = PriorityQueue<Short> { a, b -> b - a }
    val rightQueue = PriorityQueue<Short> { a, b -> a - b }

    for (i in 0 until n) {
        val num = br.readLine().toShort()

        if (leftQueue.isEmpty() || leftQueue.size <= rightQueue.size) {
            leftQueue.add(num)
        } else {
            rightQueue.add(num)
        }

        while (leftQueue.isNotEmpty() && rightQueue.isNotEmpty() && (leftQueue.peek() > rightQueue.peek())) {
            val leftTop = leftQueue.poll()
            val rightTop = rightQueue.poll()
            leftQueue.add(rightTop)
            rightQueue.add(leftTop)
        }

        bw.write("${leftQueue.peek()}\n")
    }

    bw.close()
    br.close()
}