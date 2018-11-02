package prepare

object Kujibiki2 extends App {
  import scala.io.StdIn._

  val n = readLine.toInt
  val m = readLine.toInt
  val cards = readLine.split(" ").map(_.toInt)

  var f = false
  for (i <- 0 until n) {
    for (j <- 0 until n) {
      for (k <- 0 until n) {
        if (cards.contains(m - (cards(i) + cards(j) + cards(k)))) {
          f = true
        }
      }
    }
  }
  println(if (f) "Yes" else "No")

}
