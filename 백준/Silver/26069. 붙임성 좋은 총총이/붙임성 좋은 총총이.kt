fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val map = mutableMapOf<String, Boolean>()

    fun shouldDance(a: String, b: String): Boolean {
        if (a == "ChongChong" || b == "ChongChong") return true
        return (map[a] ?: false) || (map[b] ?: false)
    }

    for (i in 0 until t) {
        val (u, v) = br.readLine().split(' ')
        val doDance = shouldDance(u, v)

        map[u] = doDance
        map[v] = doDance
    }

    println(map.count { (name, doDance) -> doDance })
    br.close()
}
