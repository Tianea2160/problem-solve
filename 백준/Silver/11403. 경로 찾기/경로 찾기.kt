import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val matrix = Array(size = n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val graph = mutableMapOf<Int, MutableList<Int>>()
    for (i in 0 until n) {
        graph[i] = mutableListOf()
    }

    val visit = Array(size = n) { mutableSetOf<Int>() }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (matrix[i][j] == 1) {
                graph[i]?.add(j)
            }
        }
    }

    fun bfs(start: Int) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)

        while (queue.isNotEmpty()) {
            val cur = queue.poll()

            for (nxt in graph[cur]!!) {
                if (!visit[start].contains(nxt)) {
                    visit[start].add(nxt)
                    queue.add(nxt)
                }
            }
        }
    }

    for (i in 0 until n) bfs(i)
    val st = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visit[i].contains(j)) {
                st.append(1)
            } else {
                st.append(0)
            }
            st.append(' ')
        }
        st.append("\n")
    }
    println(st.toString())
}