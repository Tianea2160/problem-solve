class Solution {
    fun solution(n: Long): Long {
        for(i in 1..(n/2+1)){
            if(i*i == n){
                return (i+1)*(i+1)
            }
        }
        return -1
    }
}