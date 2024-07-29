class Solution {
    fun solution(nums: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        
        for(num in nums) {
            answer.addAll((0 until num).map{ num })
        }
        
        return answer.toIntArray()
    }
}