import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    val types = IntArray(size = n) { st.nextToken().toInt() }
    st = StringTokenizer(br.readLine())
    val elements = LinkedList((0 until n).map { st.nextToken().toInt() }.filterIndexed { idx, _ -> types[idx] == 0 })

    val t = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    val nums = IntArray(t) { st.nextToken().toInt() }
    val answer = IntArray(size = t)

    for ((idx, num) in nums.withIndex()) {
        elements.addFirst(num)
        answer[idx] = elements.removeLast()
    }

    bw.write(answer.joinToString(" "))
    br.close()
    bw.close()
}