import kotlin.math.pow

class Solution {
    fun solution(numbers: IntArray): Int {
        var a = numbers.sum() * numbers.sum()
        var b = 1
        for(number in numbers) b *= number
        return if(a > b) 1 else 0
    }
}