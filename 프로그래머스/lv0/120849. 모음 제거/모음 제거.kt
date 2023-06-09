class Solution {
    fun solution(str: String): String {
        val sb = StringBuilder()
        for(c in str)
            if(c !in setOf('a', 'e', 'i', 'o', 'u'))
                sb.append(c)
        return sb.toString()
    }
}