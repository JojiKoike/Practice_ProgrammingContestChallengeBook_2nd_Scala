package prepare

import scala.collection.mutable.ArrayBuffer

object Kujibiki3 extends App {
  import scala.io.StdIn._

  // Get Inputs
  val n = readLine.toInt
  val m = readLine.toInt
  val cards = readLine.split(" ").map(_.toInt)

  // Sum of two cards array
  val kk = ArrayBuffer.empty[Int]
  for (i <- 0 until n) {
    for (j <- 0 until n) {
      kk.append(cards(i) + cards(j))
    }
  }

  // Search
  var f = false
  for (i <- 0 until n) {
    for (j <- 0 until n) {
      if (kk.contains(m - (cards(i) + cards(j)))) {
        f = true
      }
    }
  }

  // Print Result
  println(if (f) "Yes" else "No")
}
