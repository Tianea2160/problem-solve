fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val edges = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val cities = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    br.close()

    for (i in 1 until cities.size) {
        if (cities[i - 1] < cities[i]) {
            cities[i] = cities[i - 1]
        }
    }

    val answer = (0 until cities.size - 1).sumOf { i -> cities[i] * edges[i] }
    print(answer)
}