fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val sosu = Array(1001) { true }
    sosu[0] = false
    sosu[1] = false

    for (i in 2..100) {
        if (sosu[i]) {
            for (j in i * i..1000 step i) {
                sosu[j] = false
            }
        }
    }
    println(arr.count { i -> sosu[i] })
}