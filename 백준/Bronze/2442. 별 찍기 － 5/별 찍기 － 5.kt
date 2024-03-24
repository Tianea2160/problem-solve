fun main() {
    val n = readln().toInt()
    val bw = System.out.bufferedWriter()

    for (i in 0 until n) {

        val line = " ".repeat(n - i - 1) + "*".repeat(i * 2 + 1)

        bw.write(line)
        bw.newLine()
    }

    bw.close()
}