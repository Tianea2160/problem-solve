class Solution {
    fun solution(n: Long): IntArray {
        var nums = mutableListOf<Long>()
        var cur = n
        while(cur > 0){
            nums.add(cur % 10L)
            cur /= 10L
        }
        return nums.map{it.toInt()}.toIntArray()
    }
}