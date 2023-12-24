fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val map = mutableMapOf<String, Boolean>()

    fun shouldDance(a: String, b: String): Boolean {
        return (map[a] ?: false) || (map[b] ?: false)
    }

    for (i in 0 until t) {
        val (u, v) = br.readLine().split(' ')

        if (u == "ChongChong" || v == "ChongChong") {
            map[u] = true
            map[v] = true
            continue
        }

        if (shouldDance(u, v)) {
            map[u] = true
            map[v] = true
        }
    }

    println(map.count { (name, doDance) -> doDance })
    br.close()
}
