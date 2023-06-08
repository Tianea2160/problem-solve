fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val firstArray = readln().split(" ").map { it.toInt() }.toIntArray()
    val secondArray = readln().split(" ").map { it.toInt() }.toIntArray()
    val result = mutableListOf<Int>()
    var (i, j) = 0 to 0

    // 시간 복잡도 O(2n) == O(n)
    while (i < n && j < m) {
        if (firstArray[i] < secondArray[j]) {
            result.add(firstArray[i])
            i++
        } else {
            result.add(secondArray[j])
            j++
        }
    }

    if (i == n) { // 첫번째 배열의 끝에 먼저 도착한 경우
        while (j < m) {
            result.add(secondArray[j])
            j++
        }
    } else { //  j == m, 두번째 배열의 끝에 먼저 도착한 경우
        while (i < n) {
            result.add(firstArray[i])
            i++
        }
    }
    println(result.joinToString(" "))
}