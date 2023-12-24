fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    var names = mutableSetOf<String>()
    var answer = 0
    for (i in 0 until t) {
        val line = br.readLine()

        if (line == "ENTER") {
            answer += names.size
            names = mutableSetOf()
            continue
        }

        names.add(line)
    }

    answer += names.size
    println(answer)
    br.close()
}