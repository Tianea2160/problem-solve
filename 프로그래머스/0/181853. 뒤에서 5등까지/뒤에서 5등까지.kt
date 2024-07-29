class Solution {
    fun solution(nums: IntArray): IntArray {
        return nums.sortedBy{it}.slice(0..4).toIntArray()
    }
}