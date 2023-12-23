import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val array = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val visit = BooleanArray(size = array.size) { false }
    var cur = 0
    val answer = mutableListOf<Int>()

    fun getNextIdx(start: Int, variation: Int): Int {
        var idx = start
        var cnt = 0
        val flag = if (variation > 0) 1 else -1

        while (cnt < abs(variation)) {
            idx += flag * 1
            
            if (idx > array.lastIndex) idx = 0
            if (idx < 0) idx = array.lastIndex
            if (visit[idx]) continue

            cnt++
        }

        return idx
    }

    while (true) {
        visit[cur] = true
        answer.add(cur)

        if (visit.all { it }) break

        cur = getNextIdx(cur, array[cur])
    }

    bw.write(answer.map { it + 1 }.joinToString(" "))
    br.close()
    bw.close()
}

