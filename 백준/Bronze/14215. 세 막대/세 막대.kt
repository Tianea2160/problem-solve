fun main() {
    var (a, b, c) = readln().split(" ").map { it.toInt() }.sorted()
    while (c >= a + b) c--
    println(a + b + c)
}