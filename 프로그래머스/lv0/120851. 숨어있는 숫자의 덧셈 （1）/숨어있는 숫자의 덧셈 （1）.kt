class Solution {
    fun solution(string: String): Int {
        var answer: Int = 0
        for(c in string){
            if(c.isDigit())  
                answer += c.digitToInt()
        }
        return answer
    }
}