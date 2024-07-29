class Solution {
    fun solution(n: Int, nums: IntArray): IntArray {
        return nums.filter { it % n == 0 }.toIntArray()
    }
}