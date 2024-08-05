fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val str = br.readLine()
    val n = br.readLine().toInt()

    val map = mutableMapOf<Char, IntArray>()

    for (c in 'a'..'z') {
        map[c] = IntArray(size = str.length)
    }

    for ((i, c) in str.withIndex()) {
        if (i == 0) {
            map[c]!![i]++
        } else {
            // 이전 값 불러오기
            for (key in map.keys) {
                map[key]!![i] = map[key]!![i - 1]
            }

            map[c]!![i]++
        }
    }

    for (i in 0 until n) {
        val (char, u, v) = br.readLine().split(" ")
        val start = u.toInt()
        val end = v.toInt()

        val answer = if (start == 0) {
            map[char.first()]!![end]
        } else {
            map[char.first()]!![end] - map[char.first()]!![start - 1]
        }
        
        bw.write("$answer\n")
    }

    bw.close()
    br.close()
}