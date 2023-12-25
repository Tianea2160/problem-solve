import java.util.stream.Collectors

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val map = mutableMapOf<String, Int>()

    for (i in 0 until n) {
        val word = br.readLine()

        if (word.length < m) {
            continue
        }

        map[word] = (map[word] ?: 0) + 1
    }

    val answer = map.entries.stream().sorted { o1, o2 ->
        if (o1.value != o2.value) {
            o2.value.compareTo(o1.value)
        } else if (o1.key.length != o2.key.length) {
            o2.key.length.compareTo(o1.key.length)
        } else {
            o1.key.compareTo(o2.key)
        }
    }.map { it.key }.collect(Collectors.toList())

    bw.write(answer.joinToString("\n"))
    br.close()
    bw.close()
}
