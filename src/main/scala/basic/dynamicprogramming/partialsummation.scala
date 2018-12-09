package basic.dynamicprogramming

import scala.collection.mutable.ArrayBuffer

object partialsummation extends App {
  import scala.io.StdIn._

  // Get Inputs
  val n = readLine.toInt
  val a = readLine.split(" ").map(_.toInt)
  val m = readLine.split(" ").map(_.toInt)
  val K = readLine.toInt

  // Initialize DP Table
  var dp = ArrayBuffer.empty[Int]
  for (i <- 0 to K) dp.append(-1)
  dp(0) = 0

  // Solve
  for (i <- 0 until n) {
    for (j <- 0 to K) {
      if (dp(j) >= 0) {
        dp(j) = m(i)
      }
      else if (j < a(i) || dp(j - a(i)) <= 0) {
        dp(j) = -1
      } else {
        dp(j) = dp(j - a(i)) - 1
      }
    }
  }

  // Show Result
  print(if (dp(K) >= 0) "Yes" else "No")

}
