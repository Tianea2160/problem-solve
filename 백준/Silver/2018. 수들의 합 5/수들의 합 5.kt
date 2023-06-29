fun main() {
    val n = readln().toLong()
    // 좌측은 닫힌 범위(<=), 우측은 열린 범위로 하겠다(<).
    var (left, right) = 1L to 2L

    var sum : Long = 1
    var count = 0

    while (left <= right && right <= n + 1) {
        if (right == n + 1 && left == n) break

        if (sum == n) {
            count++
            if (left < n) {
                sum -= left
                left++
            }
        } else if (sum > n) {
            sum -= left
            left++
        }else{ // sum < n
            sum += right
            if(right < n+1) right++
        }
    }
    println(count+1)
}