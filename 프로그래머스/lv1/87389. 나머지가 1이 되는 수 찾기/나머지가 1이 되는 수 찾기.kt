class Solution {
    fun solution(n: Int): Int = (2..n).first{ x -> n%x == 1}
}