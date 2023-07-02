fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    val pos = readln().split(" ").map { it.toInt() }.sorted() //  내림차순
    val visit = BooleanArray(1001) { false }
    var answer = 0

    for (i in pos) {
        if (!visit[i]) {
            for (j in i until i + l)
                if (j < visit.size)
                    visit[j] = true
            answer++
        }
    }
    println(answer)
}