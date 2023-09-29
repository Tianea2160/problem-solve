fun main() {
    val (a, b, c, d, e, f) = readln().split(" ").map { it.toLong() }

    var isSolve = false
    var answer = -1 to -1

    for (x in -999..999) {
        for (y in -999..999) {
            if (a * x + b * y == c && d * x + e * y == f) {
                isSolve = true
                answer = x to y
                break
            }
        }
        if (isSolve) break
    }
    println("${answer.first} ${answer.second}")
}

private operator fun <E> List<E>.component6(): E = this[5]