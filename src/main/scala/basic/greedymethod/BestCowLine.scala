package basic.greedymethod


object BestCowLine extends App {
  import scala.io.StdIn._
  import scala.collection.mutable

  // Get Inputs
  val N = readLine.toInt
  val S = readLine

  val sb = new mutable.StringBuilder()
  var a : Int = 0
  var b : Int = N -1
  while (a <= b) {
    var left  = false
    var capt = false
    for (i <- 0 to b - a) {
      if (S(a + i) < S(b - i) && !capt) {
        left = true
        capt = true
      } else if (S(a + i) > S(b - i) && !capt) {
        left = false
        capt = true
      }
    }
    if (left) {
      sb.append(S(a))
      a += 1
    } else {
      sb.append(S(b))
      b -= 1
    }
  }

  // Show Result
  println(sb.mkString)
}
