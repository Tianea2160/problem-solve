class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var cur = n
        while(cur > 0){
            answer += (cur % 10)
            cur /= 10
        }
        return answer
    }
}