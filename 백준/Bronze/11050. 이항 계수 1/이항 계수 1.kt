tailrec fun fac(num: Int, acc: Int = 1): Int = if (num < 1) acc else fac(num - 1, acc * num)

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }
        println(fac(n) / (fac(k) * fac(n - k)))
}