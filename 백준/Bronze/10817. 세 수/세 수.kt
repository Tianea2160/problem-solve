fun main() {
    val arr = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    println(arr[1])
}