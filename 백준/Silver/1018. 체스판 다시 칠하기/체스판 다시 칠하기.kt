import kotlin.math.min

val pattern1 = listOf(
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
)
val pattern2 = listOf(
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB"
)

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val br = System.`in`.bufferedReader()
    val map = Array(size = m) { br.readLine().toCharArray() }
    br.close()

    var answer = Int.MAX_VALUE

    for (i in 0..m - 8) {
        for (j in 0..n - 8) {
            // 8*8 서치
            val diff = calculateDifferentCharCount(map, i, j)
            answer = min(answer, diff)
        }
    }

    println(answer)
}

fun calculateDifferentCharCount(map: Array<CharArray>, i: Int, j: Int): Int {
    var diff1 = 0
    var diff2 = 0

    for (a in 0 until 8) {
        for (b in 0 until 8) {
            if (pattern1[a][b] != map[i + a][j + b]) {
                diff1++
            }
        }
    }

    for (a in 0 until 8) {
        for (b in 0 until 8) {
            if (pattern2[a][b] != map[i + a][j + b]) {
                diff2++
            }
        }
    }
    return min(diff1, diff2)
}