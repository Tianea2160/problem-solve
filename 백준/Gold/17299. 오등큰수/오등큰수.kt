import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val stack = Stack<Int>()

    val map = mutableMapOf<Int, Int>()

    for (num in arr) {
        map[num] = (map[num] ?: 0) + 1
    }

    for (i in arr.indices) {
        while (stack.isNotEmpty() && (map[arr[stack.peek()]] ?: -1) < (map[arr[i]] ?: -1)) {
            arr[stack.pop()] = arr[i]
        }
        stack.add(i)
    }

    stack.forEach { i -> arr[i] = -1 }

    arr.forEach { num ->
        bw.write(num.toString())
        bw.write(" ")
    }

    bw.close()
    br.close()
}