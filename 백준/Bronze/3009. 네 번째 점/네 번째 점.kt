fun main() {
    val counterX = mutableMapOf<Int, Int>()
    val counterY = mutableMapOf<Int, Int>()

    for (i in 0 until 3) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        counterX[a] = (counterX[a] ?: 0) + 1
        counterY[b] = (counterY[b] ?: 0) + 1
    }

    val x = counterX.filterValues { it == 1 }.toList()[0]
    val y = counterY.filterValues { it == 1 }.toList()[0]
    println("${x.first} ${y.first}")
}