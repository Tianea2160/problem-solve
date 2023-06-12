class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        var sum = 0
        var cur = x
        while(cur > 0){
            sum += cur%10
            cur /= 10
        }
        return x%sum == 0
    }
}