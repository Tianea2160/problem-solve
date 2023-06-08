import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val firstArray = (0 until n).map { st.nextToken().toInt() }
    st = StringTokenizer(br.readLine())
    val secondArray = (0 until m).map { st.nextToken().toInt() }

    val result = mutableListOf<Int>()
    var (i, j) = 0 to 0

    // 시간 복잡도 O(2n) == O(n)
    while (i < n && j < m) {
        if (firstArray[i] < secondArray[j]) {
            result.add(firstArray[i])
            i++
        } else {
            result.add(secondArray[j])
            j++
        }
    }

    if (i == n) { // 첫번째 배열의 끝에 먼저 도착한 경우
        while (j < m) {
            result.add(secondArray[j])
            j++
        }
    } else { //  j == m, 두번째 배열의 끝에 먼저 도착한 경우
        while (i < n) {
            result.add(firstArray[i])
            i++
        }
    }
    bw.write(result.joinToString(" "))
    bw.close()
    br.close()
}