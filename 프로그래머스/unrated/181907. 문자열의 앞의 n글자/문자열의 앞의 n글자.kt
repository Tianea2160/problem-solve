class Solution {
    fun solution(str: String, n: Int): String {
        val stringBuilder = StringBuilder()
        for(i in 0 until n) stringBuilder.append(str[i])
        return stringBuilder.toString()
    }
}