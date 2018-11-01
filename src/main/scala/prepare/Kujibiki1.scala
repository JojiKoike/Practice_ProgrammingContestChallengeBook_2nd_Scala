package prepare

object Kujibiki1 extends App {

  import scala.io.StdIn._

  val n = readLine.toInt
  val m = readLine.toInt
  val cards = readLine.split(",").map(_.toInt)

  var flag = false

  for (i <- 0 until n) {
    for (j <- 0 until n) {
      for (k <- 0 until n) {
        for (l <- 0 until n) {
          if (cards(i) + cards(j) + cards(k) + cards(l) == m) {
            flag = true
          }
        }
      }
    }
  }

  println(if (flag) "Yes" else "No")

}
