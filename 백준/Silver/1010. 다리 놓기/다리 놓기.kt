import java.math.BigInteger

fun factorial(n: Long): BigInteger {
    var answer = BigInteger.ONE

    for (i in 1L..n) {
        answer = answer.multiply(BigInteger.valueOf(i))
    }

    return answer
}


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toLong()
    for (i in 0 until t) {
        val (n, m) = br.readLine().split(' ').map { it.toLong() }

        bw.write(factorial(m).divide(factorial(n).multiply(factorial(m - n))).toString())
        bw.newLine()
    }
    bw.close()
    br.close()
}