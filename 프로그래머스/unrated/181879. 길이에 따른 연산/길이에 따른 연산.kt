class Solution {
    fun solution(nums: IntArray): Int {
        return if(nums.size >= 11){
            nums.sum()            
        }else{
            var result = 1
            for(num in nums) result *= num
            result
        }
    }
}