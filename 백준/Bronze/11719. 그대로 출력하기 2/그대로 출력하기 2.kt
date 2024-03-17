import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = System.out.bufferedWriter()

    while(sc.hasNext()){
        bw.write(sc.nextLine())
        bw.newLine()
    }

    bw.close()
    sc.close()
}