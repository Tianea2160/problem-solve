import java.util.*

fun main() {
    val (n, k) = readln().split(' ').map { it.toInt() }

    val queue = LinkedList((1..n).toList())
    var cur = 1
    val answer = mutableListOf<Int>()

    while (queue.isNotEmpty()) {
        while (cur < k) {
            queue.add(queue.removeFirst())
            cur++
        }
        answer.add(queue.removeFirst())
        cur = 1
    }
    println(answer.joinToString(prefix = "<", postfix = ">", separator = ", "))
}