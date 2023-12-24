fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val nums = br.readLine().split(' ').map { it.toInt() }
    println(nums.min() * nums.max())
    br.close()
}