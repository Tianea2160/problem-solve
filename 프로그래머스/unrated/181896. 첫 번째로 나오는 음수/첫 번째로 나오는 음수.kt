class Solution {
    fun solution(nums: IntArray): Int {
        for(i in nums.indices){
            if(nums[i] < 0){
                return i
            }
        }
        return -1
    }
}