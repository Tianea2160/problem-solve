fun main() {
    var n = readln().toInt()

    var cur = 2
    while(n != 1){
        while(n % cur == 0){
            println(cur)
            n /= cur
        }
        cur++
    }
}