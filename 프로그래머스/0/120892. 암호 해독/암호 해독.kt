class Solution {
    fun solution(cipher: String, code: Int): String {
        return (code..cipher.length step code).map { cipher[it-1] }.joinToString("")
    }
}