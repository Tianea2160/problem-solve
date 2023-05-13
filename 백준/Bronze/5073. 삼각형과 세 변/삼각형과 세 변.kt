fun main() {
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
        if (a == 0 && b == 0 && c == 0) break
        if (a + b <= c) println("Invalid")
        else {
            if (a == b && b == c) println("Equilateral")
            else if (a == b || b == c || a == c) println("Isosceles")
            else println("Scalene")
        }
    }
}