package basic.dynamicprogramming


object unlimitedknapsack extends App {
  import scala.io.StdIn._
  import scala.collection.mutable.ArrayBuffer

  // Step 1 : Get n : Number of items, w : Maximum sum of weight
  val Array(n, w) = readLine.split(" ").map(_.toInt)

  // Step 2 : Build Weight and Value Array
  val weights = new ArrayBuffer[Int]()
  val values = new ArrayBuffer[Int]()
  for (i <- 0 until n) {
    val wv = readLine.split(" ").map(_.toInt)
    weights.append(wv(0))
    values.append(wv(1))
  }

  // Step 3 : Initialize DP
  var dp = ArrayBuffer.empty[Array[Int]]
  for (i <- 0 to n) {
    val row = new ArrayBuffer[Int]()
    for (j <- 0 to n * values.max) {
      row.append(1000000000)
    }
    dp.append(row.toArray)
  }
  dp(0)(0) = 0

  // Step 4 : Solve
  for (i <- 0 until n) {
    for (j <- 0 to n * values.max) {
      if (values(i) > j) {
        dp(i + 1)(j) = dp(i)(j)
      } else {
        dp(i + 1)(j) = math.min(dp(i)(j), dp(i)(j - values(i)) + weights(i))
      }
    }
  }

  // Step 5 : Show Result
  var res = 0
  for (i <- 0 to n * values.max) {
    if (dp(n)(i) <= w) res = i
  }
  printf("Result : %d\n", res)

}
