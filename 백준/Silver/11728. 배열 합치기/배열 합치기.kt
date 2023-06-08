
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val firstArray = readln().split(" ").map { it.toInt() }.toIntArray()
    val secondArray = readln().split(" ").map { it.toInt() }.toIntArray()
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0

    while (i < n && j < m) {
        if (firstArray[i] < secondArray[j]) {
            result.add(firstArray[i])
            i++
        } else {
            result.add(secondArray[j])
            j++
        }
    }

    if (i == n) {
        while (j < m) {
            result.add(secondArray[j])
            j++
        }
    } else { //  j == m
        while (i < n) {
            result.add(firstArray[i])
            i++
        }
    }
    println(result.joinToString(" "))
}

