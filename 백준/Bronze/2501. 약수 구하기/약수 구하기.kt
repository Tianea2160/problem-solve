fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = (1..n).filter { i -> n % i == 0 }
    if (arr.size < k)
        print(0)
    else
        print(arr[k - 1])
}