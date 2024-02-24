fun main() {
    val br = System.`in`.bufferedReader()

    val ascending = "12345678"
    val descending = "87654321"

    val line = br.readLine().replace(" ", "")

    when (line) {
        ascending -> println("ascending")
        descending -> println("descending")
        else -> println("mixed")
    }

    br.close()
}