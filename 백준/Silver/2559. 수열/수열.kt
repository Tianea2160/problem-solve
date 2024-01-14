fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toLong() }.toLongArray()
    val results = mutableListOf<Long>()
    results.add((0 until k).sumOf { arr[it] })

    for (i in k until n) {
        results.add(results.last() - arr[i - k] + arr[i])
    }

    println(results.max())
    br.close()
}