fun rangeSum(start: Long, end: Long): Long {
    return (end + 1) * end / 2 - (start + 1) * start / 2 + start
}

fun main() {
    val n = readln().toLong()
    var cnt = 0L
    for(i in 1..n-2){
        cnt += rangeSum(1, i)
    }
    val second = 3
    println("$cnt\n$second")
}