class Solution {
    fun solution(string: String, n: Int): String {
        val buffer = StringBuilder()
        for(c in string)
            for(i in 0 until n) 
                buffer.append(c)
        return buffer.toString()
    }
}