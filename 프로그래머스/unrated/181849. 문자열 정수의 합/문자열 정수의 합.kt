class Solution {
    fun solution(str: String): Int {
        var result = 0
        //O(n)
        for(c in str) result += (c.toInt() - '0'.toInt())
        return result
    }
}