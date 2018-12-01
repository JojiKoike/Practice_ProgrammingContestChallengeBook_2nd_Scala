package basic.dynamicprogramming

import scala.collection.mutable.ArrayBuffer

object lcs extends App {
  import scala.io.StdIn._

  val Array(n, m) = readLine.split(" ").map(_.toInt)
  val Array(s, t) = readLine.split(" ")

  var dp = ArrayBuffer.empty[Array[Int]]
  for (i <- 0 until n + 1) {
    val dprow = ArrayBuffer.empty[Int]
    for (j <- 0 until m + 1) {
      dprow.append(0)
    }
    dp.append(dprow.toArray)
  }

  for (i <- 0 until n) {
    for (j <- 0 until m) {
      dp(i + 1)(j + 1) = if (s(i) == t(j)) dp(i)(j) + 1 else math.max(dp(i + 1)(j), dp(i)(j + 1))
    }
  }

  printf("Result : %d\n", dp(n)(m))
}
