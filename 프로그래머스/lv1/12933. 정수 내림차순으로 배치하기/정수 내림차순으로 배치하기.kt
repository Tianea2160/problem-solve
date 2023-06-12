class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var numbers = mutableListOf<Long>()
        var cur = n
        
        while(cur > 0){
            numbers.add(cur%10)
            cur /= 10
        }
        numbers.sortDescending()
        for(number in numbers)
            answer = answer*10 + number
        return answer
    }
}