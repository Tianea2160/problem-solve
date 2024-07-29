class Solution {
    fun solution(array: IntArray): IntArray {
        var max = -1
        var maxIdx = -1
        
        
        for((idx, num) in array.withIndex()){
            if(max < num){
                max = num
                maxIdx = idx 
            }
        }
        
        return intArrayOf(max, maxIdx)
    }
}