fun main() {
    val (x, y) = readln().split(" ").map { it.toInt() }

    val a = setOf(1, 3, 5, 7, 8, 10, 12)
    val b = setOf(4, 6, 9, 11)
    val c = setOf(2)

    var day = 0
    for (i in 1 until x) {
        day += when (i) {
            in a -> 31
            in b -> 30
            in c -> 28
            else -> 0
        }
    }
    day += y
    val mod = day % 7
    val answer = when (mod) {
        1 -> "MON"
        2 -> "TUE"
        3 -> "WED"
        4 -> "THU"
        5 -> "FRI"
        6 -> "SAT"
        0 -> "SUN"
        else -> ""
    }
    println(answer)
}