fun main() {
    val bw = System.out.bufferedWriter()
    val lines = mutableListOf<String>()

    fun printAnswer(lines: List<String>) {
        bw.write(lines.size.toString())
        bw.newLine()
        bw.write(lines.joinToString("\n"))
    }

    fun move(start: Int, end: Int) {
        lines.add("$start $end")
    }

    fun hanoi(start: Int, mid: Int, end: Int, n: Int) {
        if (n == 1) return move(start, end)

        hanoi(start, end, mid, n - 1)
        move(start, end)
        hanoi(mid, start, end, n - 1)
    }

    val n = readln().toInt()
    hanoi(1, 2, 3, n)
    printAnswer(lines)
    bw.close()
}