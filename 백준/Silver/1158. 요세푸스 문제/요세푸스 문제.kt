import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = LinkedList<Int>()

    for (i in 1..n) list.add(i)

    var cur = 1
    val answer = mutableListOf<Int>()

    while (list.isNotEmpty()) {
        val first = list.removeFirst()

        if (cur == k) {
            answer.add(first)
            cur = 1
            continue
        }

        cur++
        list.addLast(first)
    }

    val result = answer.joinToString(separator = ", ", prefix = "<", postfix = ">")
    println(result)
}