import java.util.*
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = LongArray(n + 2) { 0L }

    for (i in 1..n) {
        arr[i] = br.readLine().toLong()
    }
    var answer = 0L
    val stack = Stack<Int>()

    stack.add(0)

    for (i in 1..n + 1) {
        while (stack.isNotEmpty() && arr[stack.peek()] > arr[i]) {
            val c = stack.peek()
            stack.pop()
            val width = i - stack.peek() - 1
            answer = max(answer, width * arr[c])
        }
        stack.add(i)
    }

    print(answer)
    br.close()
}