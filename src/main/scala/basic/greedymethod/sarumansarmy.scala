package basic.greedymethod

object sarumansarmy extends App {
  import scala.io.StdIn._

  val N = readLine.toInt
  val R = readLine.toInt
  val X  = (for (i <- 0 until N) yield readLine.toInt).sorted

  var i = 0
  var ans = 0

  while (i < N) {
    // Uncovered left side end point
    val s = X(i)
    i += 1
    while (i < N && X(i) <= s + R) i += 1

    // P is New Marking Point
    val p = X(i -1)

    // Forward until over p + R
    while (i < N && X(i) <= p + R) i += 1

    ans += 1
  }
  printf("Result: %d\n", ans)
}
