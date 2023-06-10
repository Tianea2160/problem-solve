class Solution {
    fun solution(n: Long): IntArray {
        var list = mutableListOf<Int>()
        var cur = n
        while(cur > 0){
            list.add((cur%10).toInt())
            cur /= 10
        }
        return list.toIntArray()
    }
}