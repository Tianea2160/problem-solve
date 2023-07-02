fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    var max = 0
    var sum = 0
    val list = MutableList(size = n) { br.readLine().toInt() }

    list.sortDescending()
    max = list[0]
    sum = list[0]

    for (i in 1 until list.size) {
        var tmp = sum + list[i]
        if (tmp.toDouble() / (i + 1) > list[i].toDouble()) {
            tmp = list[i] * (i + 1)
        }
        if(tmp > max){
            max = tmp
            sum = tmp
        }
    }
    println(max)
}