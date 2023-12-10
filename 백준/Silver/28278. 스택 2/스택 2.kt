import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    val stack = Stack<Int>()
    val st = StringBuilder()

    for (i in 0 until t) {
        val input = br.readLine()
        val args = input.split(" ")
        val commend = args.first()

        if (commend == "1") {
            stack.add(args[1].toInt())
            continue
        }

        val value = when (commend) {
            "2" -> if (stack.isEmpty()) -1 else stack.pop()
            "3" -> stack.size
            "4" -> if (stack.isEmpty()) 1 else 0
            "5" -> if (stack.isEmpty()) -1 else stack.peek()
            else -> throw IllegalArgumentException()
        }
        st.append(value).append('\n')
    }
    bw.write(st.toString())
    br.close()
    bw.close()
}