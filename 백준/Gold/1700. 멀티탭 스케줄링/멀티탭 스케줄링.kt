fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val plugs = br.readLine().split(" ").map { it.toInt() }
    br.close()

    var answer = 0
    val used = BooleanArray(k + 1) { false }

    for ((index, plug) in plugs.withIndex()) {
        if (used[plug]) continue
        else {
            if (used.count { it } < n) {
                used[plug] = true
            } else {
                // 앞으로 추가적으로 사용할 수 있는 플러그를 모은다.
                val moreUse = mutableListOf<Int>()
                for (next in index until k)
                    if (used[plugs[next]] && plugs[next] !in moreUse)
                        moreUse.add(plugs[next])
                
                // 더이상 사용하지 않는 플러그를 삭제한다.
                if (moreUse.size != n) {
                    for ((nxt, use) in used.withIndex()) {
                        if (use && nxt !in moreUse) {
                            used[nxt] = false
                            break
                        }
                    }
                // 더이상 사용하지 않는 플러그가 없다면 가장 나중에 사용하는 플러그를 삭제한다.
                } else used[moreUse.last()] = false

                answer++
                used[plug] = true
            }
        }
    }

    println(answer)
}