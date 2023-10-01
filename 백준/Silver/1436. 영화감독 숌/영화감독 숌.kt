fun main() {
    val n = readln().toInt()
    var cur = 666

    for (i in 1 until n) {
        cur = next(cur)
    }
    println(cur)
}

fun next(number: Int): Int {
    var cur = number + 1
    while (isNotValid(cur)) {
        cur++
    }
    return cur
}

fun isValid(number: Int): Boolean = "666" in number.toString()
fun isNotValid(number: Int): Boolean = !isValid(number)