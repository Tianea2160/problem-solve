class Solution {
    fun solution(hp: Int): Int {
        var answer: Int = 0
        var mod = 0
        
        answer += hp / 5
        mod = hp % 5
        
        answer += mod / 3
        answer += mod % 3
        
        return answer
    }
}