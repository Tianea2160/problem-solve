import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    while (true) {
        val line = br.readLine()

        if (line == ".") break

        val stack = Stack<Char>()
        var answer = true

        for (c in line) {
            when (c) {
                '(' -> stack.add(c)
                '[' -> stack.add(c)
                ')' -> {
                    if (stack.isNotEmpty() && stack.peek() == '(') {
                        stack.pop()
                    } else {
                        answer = false
                        break
                    }
                }

                ']' -> {
                    if (stack.isNotEmpty() && stack.peek() == '[') {
                        stack.pop()
                    } else {
                        answer = false
                        break
                    }
                }
            }
        }

        answer = answer && stack.isEmpty()
        println(if (answer) "yes" else "no")
    }

    br.close()
}