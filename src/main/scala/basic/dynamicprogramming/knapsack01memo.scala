package basic.dynamicprogramming

import scala.collection.mutable.ArrayBuffer

object knapsack01memo extends App {
  import scala.io.StdIn._

  // n : Number of items, w : Upper Limit weight
  val Array(n, w) = readLine.split(" ").map(_.toInt)
  val weights = readLine.split(" ").map(_.toInt)
  val values = readLine.split(" ").map(_.toInt)

  // Initialize Memo Table
  var dp = ArrayBuffer.empty[Array[Int]]
  for (i <- 0 until n + 1) {
    val row = ArrayBuffer.empty[Int]
    for (j <- 0 until w + 1) {
      row.append(-1)
    }
    dp.append(row.toArray)
  }

  // Solve with memo
  def rec(i: Int, j: Int): Int = {
    if (dp(i)(j) >= 0) {
      printf("i : %d, j : %d, %d\n",i, j, dp(i)(j))
      return dp(i)(j)
    }
    var res = 0
    if (i == n) {
      res = 0
    } else if (j < weights(i)) {
      res = rec(i + 1, j)
    } else {
      res = math.max(rec(i + 1, j), rec(i + 1, j - weights(i)) + values(i))
    }
    dp(i)(j) = res
    res
  }


  printf("Result : %d\n", rec(0, w))

  for (i <- dp.indices) {
    for (j <- dp(i).indices) {
      printf(" %d ", dp(i)(j))
    }
    println("")
  }
}
