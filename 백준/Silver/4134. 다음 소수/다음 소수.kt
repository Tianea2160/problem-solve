import kotlin.math.sqrt

fun isPrime(num: Long): Boolean {
    if (num < 2L) return false
    if (num == 2L || num == 3L) return true
    if (num % 2 == 0L || num % 3 == 0L) return false
    for (i in 5..sqrt(num.toDouble()).toLong() + 1L) {
        if (num % i == 0L || num % (i + 2L) == 0L) return false
    }
    return true
}


fun nextPrime(num: Long): Long {
    var cur = num
    while (!isPrime(cur)) cur++
    return cur
}

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toLong()
        println(nextPrime(n))
    }
}