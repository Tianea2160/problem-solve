class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        if (arr1.size != arr2.size) {
            return arr1.size.compareTo(arr2.size)
        }
        
        val (u, v) = arr1.sum() to arr2.sum()
        
        return when {
            u == v -> 0
            u > v -> 1
            else -> -1
        }
        
    }
}