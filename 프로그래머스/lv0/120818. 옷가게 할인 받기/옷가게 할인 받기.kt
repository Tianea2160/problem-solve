class Solution {
    fun solution(price: Int) : Int = when(price){
        in 0 until 100000-> price
        in 100000 until 300000 -> price * 0.95
        in 300000 until 500000 -> price * 0.9
        else -> price * 0.8
    }.toInt()
}