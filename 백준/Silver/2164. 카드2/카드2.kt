import java.util.*

fun main() {
    val n = readln().toInt()
    val queue = LinkedList((1..n).toList())

    while (queue.size > 1) {
        queue.removeFirst()
        queue.add(queue.removeFirst())
    }

    println(queue.first)
}