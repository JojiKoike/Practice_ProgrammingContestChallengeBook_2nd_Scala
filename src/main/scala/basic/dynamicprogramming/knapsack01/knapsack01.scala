package basic.dynamicprogramming

object knapsack01 extends App {
  import scala.io.StdIn._

  val Array(n, w) = readLine.split(" ").map(_.toInt)
  val weights = readLine.split(" ").map(_.toInt)
  val values = readLine.split(" ").map(_.toInt)

  def rec(i: Int, j: Int): Int = {
    var res = 0
    if (i == n) {
      res = 0
    } else if (j < weights(i)) {
      res = rec(i + 1, j)
    } else {
      res = math.max(rec(i + 1, j), rec(i + 1, j - weights(i)) + values(i))
    }
    res
  }

  printf("Result %d\n", rec(0, w))

}
