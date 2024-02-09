import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val stack = Stack<Int>()
    
    for (i in 0..numbers.lastIndex) {
        while (stack.isNotEmpty() && numbers[stack.peek()] < numbers[i]) {
            numbers[stack.pop()] = numbers[i]
        }

        stack.add(i)
    }

    stack.forEach { i -> numbers[i] = -1 }

    numbers.forEach { number ->
        bw.write(number.toString())
        bw.write(" ")
    }

    bw.close()
    br.close()
}