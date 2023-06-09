class Solution {
    fun solution(string: String): Int {
        var answer: Int = 0
        for(c in string){
            if(c >= '0' && c <= '9')  
                answer += c.digitToInt()
        }
        return answer
    }
}