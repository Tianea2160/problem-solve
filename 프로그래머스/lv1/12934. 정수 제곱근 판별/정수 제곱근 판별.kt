class Solution {
    fun solution(n: Long): Long {
        for(i in 1..n.toLong()){
            val cur = i*i
            if(cur > n) break
            if(cur == n) return (i+1)*(i+1)
        }
        return -1
    }
}