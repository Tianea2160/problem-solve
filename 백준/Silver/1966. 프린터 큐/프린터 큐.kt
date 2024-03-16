import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()

    for (i in 0 until t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val priorities = br.readLine().split(" ").mapIndexed { idx, value -> value.toInt() to (idx == m) }

        val cur = LinkedList(priorities)
        var cnt = 0
        while (cur.isNotEmpty()) {
            val first = cur.removeFirst()
            val priority = first.first
            val needResult = first.second

            if (cur.stream().anyMatch { it.first > priority }) { // has more high priority
                cur.addLast(first)
                continue
            }

            cnt++
            if (needResult) {
                bw.write(cnt.toString())
                bw.newLine()
            }
        }
    }

    br.close()
    bw.close()
}