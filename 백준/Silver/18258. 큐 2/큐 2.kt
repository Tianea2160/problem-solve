import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    val queue = LinkedList<Int>()

    for (i in 0 until t) {
        val args = br.readLine().split(' ')
        val cmd = args.first()

        if ("push" == cmd) {
            queue.add(args[1].toInt())
            continue
        }

        val value = when (cmd) {
            "pop" -> if (queue.isEmpty()) -1 else queue.removeFirst()
            "size" -> queue.size
            "empty" -> if (queue.isEmpty()) 1 else 0
            "front" -> queue.firstOrNull() ?: -1
            "back" -> queue.lastOrNull() ?: -1
            else -> -1
        }

        bw.write(value.toString())
        bw.newLine()
    }

    bw.close()
    br.close()
}