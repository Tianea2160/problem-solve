fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.toIntArray()

    var l = 0
    var r = 0
    var cnt = 0
    var sum = nums[0]

    while (true) {
        if (sum > m) { // 합이 크면 왼쪽을 옮긴다
            sum -= nums[l]
            l++
        } else if (sum == m) { // 합 같으면 cnt를 올리고 왼쪽을 옮긴다.
            sum -= nums[l]
            l++
            cnt++
        } else { // 합이 작으면 우측을 올리고 만약에 우측이 범위를 벗어나면 멈춘다.
            r++
            if(r == n) break
            sum += nums[r]
        }
    }
    println(cnt)
}