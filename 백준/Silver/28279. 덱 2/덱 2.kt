import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val queue = LinkedList<Int>()

    for (i in 0 until t) {
        val args = br.readLine().split(' ').map { it.toInt() }
        val cmd = args.first()

        when (cmd) {
            1 -> {
                queue.addFirst(args[1])
                continue
            }

            2 -> {
                queue.addLast(args[1])
                continue
            }
        }

        val value = when (cmd) {
            3 -> if (queue.isEmpty()) -1 else queue.removeFirst()
            4 -> if (queue.isEmpty()) -1 else queue.removeLast()
            5 -> queue.size
            6 -> if (queue.isEmpty()) 1 else 0
            7 -> if (queue.isEmpty()) -1 else queue.first()
            8 -> if (queue.isEmpty()) -1 else queue.last()
            else -> -1
        }

        bw.write(value.toString())
        bw.newLine()
    }
    bw.close()
    br.close()
}