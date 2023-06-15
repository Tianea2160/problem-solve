class Solution {
    fun solution(x: Int, n: Int): LongArray = (1..n.toLong()).map{i->x*i}.toLongArray()
}