fun main() {
    val n = readln().toInt()

    for(i in 0 until n){
        println("*".repeat(n - i))
    }
}