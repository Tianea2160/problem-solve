import kotlin.math.min

fun main() {
    val line = readln()

    for (i in 0..line.length step 10) {
        println(line.substring(i, min(i + 10, line.length)))
    }
}