fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val set = HashSet<String>()

    for (i in 0 until n) {
        val (name, command) = br.readLine().split(" ")

        if (command == "enter") {
            set.add(name)
        } else if (command == "leave") {
            set.remove(name)
        }
    }

    set.toList().sortedDescending().forEach(::println)
}