package basic.dynamicprogramming

import scala.collection.mutable.ArrayBuffer

object knapsack01rec extends App {
  import scala.io.StdIn._

  // Get Input values
  val Array(n, w) = readLine.split(" ").map(_.toInt)
  val weights = readLine.split(" ").map(_.toInt)
  val values = readLine.split(" ").map(_.toInt)

  // Initialize DP Table
  var dp = ArrayBuffer.empty[Array[Int]]
  for (i <- 0 until n + 1) {
    val row = ArrayBuffer.empty[Int]
    for (j <- 0 until w + 1) {
      row.append(0)
    }
    dp.append(row.toArray)
  }

  // Solve
  for (i <- n -1 to 0 by -1) {
    for (j <- 0 to w) {
      if (j < weights(i)) {
        dp(i)(j) = dp(i + 1)(j)
      } else {
        dp(i)(j) = math.max(dp(i + 1)(j), dp(i + 1)(j - weights(i)) + values(i))
      }
    }
  }

  printf("Result : %d\n", dp(0)(w))

}
