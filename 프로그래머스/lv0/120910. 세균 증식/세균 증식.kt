class Solution {
    fun solution(n: Int, t: Int): Int {
        var cur = n
        (1..t).forEach{
            cur *= 2
        }
        return cur
    }
}