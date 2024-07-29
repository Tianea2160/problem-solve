class Solution {
    private val diff = 'a' - 'A'

    fun solution(str: String): String {
        return str.map { this.convert(it) }.joinToString("")
    }

    private fun convert(c: Char): Char = when (c) {
        in 'A'..'Z' -> c + diff
        in 'a'..'z' -> c - diff
        else -> c
    }
}