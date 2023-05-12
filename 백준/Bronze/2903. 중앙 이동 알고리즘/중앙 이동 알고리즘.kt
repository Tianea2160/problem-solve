import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    var line = 2
    for (i in 0 until n) line += line - 1
    println(line.toDouble().pow(2).toInt())
}