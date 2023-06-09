class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int {
        var answer = 0
        val set = s1.toSet()
        for(e in s2){
            if(e in set) 
                answer++
        }
        return answer
    }
}