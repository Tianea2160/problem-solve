// 시간복잡도 O(n log n)
class Solution {
    fun solution(sides: IntArray): Int {
        sides.sort()
        val (a, b, c) = sides
        return if(c >= a + b) 2 else 1
    }
}