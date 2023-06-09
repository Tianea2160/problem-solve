class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var answer: Int = 0
        var idx = 0
        while(answer <= n && idx < numbers.size){
            answer += numbers[idx++]   
        }
        return answer
    }
}