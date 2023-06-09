class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        val result = arr.copyOf()
        
        if(k%2 == 1){
            for(i in arr.indices) result[i] *= k
        }else{
            for(i in arr.indices) result[i] += k            
        }
        return result
    }
}