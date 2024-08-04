fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val str = br.readLine()
    val n = br.readLine().toInt()

    for (i in 0 until n) {
        val (a, b, c) = br.readLine().split(" ")
        val (start, end) = b.toInt() to c.toInt()

        val count = str.substring(start..end).count { it == a[0] }
        bw.write("$count\n")
    }

    bw.close()
    br.close()
}