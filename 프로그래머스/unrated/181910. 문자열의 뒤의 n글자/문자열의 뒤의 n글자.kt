class Solution {
    fun solution(string: String, n: Int): String
        = string.slice((string.length - n)..string.lastIndex)
}