fun main() {
    val n = readln().toInt()
    val bw = System.out.bufferedWriter()

    for(i in 0 until n){
        val line = " ".repeat(i) + "*".repeat(n-i)
        bw.write(line)
        bw.newLine()
    }
    bw.close()
}