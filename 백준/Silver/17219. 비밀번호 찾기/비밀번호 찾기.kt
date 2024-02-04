fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, String>()

    for (i in 0 until n) {
        val (link, password) = br.readLine().split(" ")
        map[link] = password
    }

    for (i in 0 until m) {
        val link = br.readLine()
        bw.write(map[link] ?: "")
        bw.newLine()
    }

    br.close()
    bw.close()
}