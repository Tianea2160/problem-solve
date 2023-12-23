import java.util.*

fun main() {
    val t = readln().toInt()
    val queue = LinkedList<Int>()
    readln().split(' ').forEach { queue.add(it.toInt()) }

    val stack = Stack<Int>()

    var cur = 1
    var answer = true

    while (true) {
        if (stack.isNotEmpty() && stack.peek() == cur) {
            // 필요한게 stack에 있는 경우
            stack.pop()
            cur++
            continue
        }

        while (queue.isNotEmpty() && queue.first() != cur) {//  queue에 있는 것이 맞지 않는 경우
            val first = queue.removeFirst()
            stack.add(first)
        }

        if (queue.isEmpty() && stack.isNotEmpty()) {
            answer = false
            break
        } else {
            if (queue.isNotEmpty() && queue.first() == cur) {
                queue.removeFirst()
                cur++
            }
        }

        if (stack.isEmpty() && queue.isEmpty()) break
    }
    println(if (answer) "Nice" else "Sad")
}