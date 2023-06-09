class Solution {
    fun solution(n: Int): Int = (1..n).filter{i-> n%i==0}.sum()
}