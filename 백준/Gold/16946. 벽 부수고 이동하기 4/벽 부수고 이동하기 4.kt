import java.util.LinkedList

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n) { Array(m) { 0 } }
    val groupMap = Array(n) { Array(m) { 0 } }
    val countMap = mutableMapOf<Int, Int>()
    val answer = Array(n) { Array(m) { 0 } }
    val visited: Array<Array<Boolean>> = Array(n) { Array(m) { false } }
    var idx = 1

    // init
    for (y in 0 until n) {
        val line = br.readLine()

        for (x in 0 until m) {
            map[y][x] = line[x] - '0'
        }
    }

    for (y in 0 until n) {
        for (x in 0 until m) {
            if (map[y][x] == 1 || visited[y][x]) continue
            countMap[idx] = bfs(y to x, map, groupMap, visited, n, m, idx)
            idx++
        }
    }

    for (y in 0 until n) {
        for (x in 0 until m) {
            if (map[y][x] != 1) continue
            val set = mutableSetOf<Int>()

            for (i in 0 until 4) {
                val ny = y + dy[i]
                val nx = x + dx[i]

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue
                if (groupMap[ny][nx] == 0) continue
                set.add(groupMap[ny][nx])
            }

            val sum = set.sumOf { e -> countMap[e]!! }
            answer[y][x] = (sum + 1) % 10
        }
    }

    answer.forEach { line -> bw.write("${line.joinToString("")}\n") }

    bw.close()
    br.close()
}

fun bfs(
    start: Pair<Int, Int>,
    map: Array<Array<Int>>,
    groupMap: Array<Array<Int>>,
    visited: Array<Array<Boolean>>,
    n: Int,
    m: Int,
    idx: Int,
): Int {
    val queue = LinkedList<Pair<Int, Int>>()

    visited[start.first][start.second] = true
    groupMap[start.first][start.second] = idx
    queue.add(start)
    var count = 1

    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll()

        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue
            if (map[ny][nx] == 1 || visited[ny][nx]) continue

            visited[ny][nx] = true
            groupMap[ny][nx] = idx
            queue.add(ny to nx)
            count++
        }
    }

    return count
}