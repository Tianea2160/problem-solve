fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    val map = mutableMapOf<Int, Int>()
    for (i in listOf(a, b, c)) {
        map[i] = (map[i] ?: 0) + 1
    }

    if (a + b + c == 180) {
        if (a == b && b == c) println("Equilateral")
        else {
            for (key in map.keys) {
                if (map[key] == 2) {
                    println("Isosceles")
                    return
                }
            }
            println("Scalene")
        }
    } else {
        println("Error")
    }
}