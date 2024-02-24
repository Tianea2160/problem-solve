const val PUSH_FRONT = "push_front"
const val PUSH_BACK = "push_back"
const val POP_FRONT = "pop_front"
const val POP_BACK = "pop_back"
const val SIZE = "size"
const val EMPTY = "empty"
const val FRONT = "front"
const val BACK = "back"

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()


    for (i in 0 until n) {
        val args = br.readLine().split(" ")
        val cmd = args.first()

        when (cmd) {

            PUSH_FRONT -> {
                val num = args[1].toInt()
                deque.addFirst(num)
            }

            PUSH_BACK -> {
                val num = args[1].toInt()
                deque.addLast(num)
            }

            POP_FRONT -> {
                val num = deque.removeFirstOrNull()?: -1
                bw.write(num.toString())
                bw.newLine()
            }

            POP_BACK -> {
                val num = deque.removeLastOrNull()?: -1
                bw.write(num.toString())
                bw.newLine()
            }

            SIZE -> {
                val size = deque.size
                bw.write(size.toString())
                bw.newLine()
            }

            EMPTY -> {
                val result = if(deque.isEmpty()) 1 else 0
                bw.write(result.toString())
                bw.newLine()
            }

            FRONT -> {
                val front = deque.firstOrNull() ?: -1
                bw.write(front.toString())
                bw.newLine()
            }

            BACK -> {
                val back = deque.lastOrNull() ?: -1
                bw.write(back.toString())
                bw.newLine()
            }
        }
    }


    br.close()
    bw.close()
}