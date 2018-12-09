package basic.dynamicprogramming

import scala.collection.mutable.ArrayBuffer

object unlimitedknapsack extends App {
  import scala.io.StdIn._

  // Get Input Data
  val n = readLine.toInt
  val wv = for (i <- 0 until n) yield readLine.split(" ").map(_.toInt)
  val W = readLine.toInt

  // Initialize DP Table
  var dp = ArrayBuffer.empty[Array[Int]]
  for (i <-0 to n) {
    val row = new ArrayBuffer[Int]()
    for (j <- 0 to W) {
      row.append(0)
    }
    dp.append(row.toArray)
  }
  dp(0)(0) = 0

  // Solve
  for (i <- 0 until n) {
    val w = wv(i)(0)
    val v = wv(i)(1)
    for (j <- 0 to W) {
      if (j < w) {
        dp(i + 1)(j) = dp(i)(j)
      } else {
        dp(i + 1)(j) = math.max(dp(i)(j), dp(i + 1)(j - w) + v)
      }
    }
  }

  // Show Result
  printf("Result : %d\n", dp(n)(W))


}
