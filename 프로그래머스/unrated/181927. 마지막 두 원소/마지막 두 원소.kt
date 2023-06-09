class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size+1){0}
        
        for(i in numbers.indices) answer[i] = numbers[i]
        val next = numbers.last()
        val prev = numbers[numbers.lastIndex-1]
        
        answer[answer.lastIndex] = if(next > prev){
            next - prev
        }else{
            next*2
        }
        return answer
    }
}