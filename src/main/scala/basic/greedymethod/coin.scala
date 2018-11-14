package basic.greedymethod

object coin extends App {
  import scala.io.StdIn._

  // Coin
  val v = Array(1, 5, 10, 50, 100, 500)

  // Input
  val c_n = readLine.split(" ").map(_.toInt)
  val A = readLine.toInt

  var ans = 0
  var a = A
  for (i <- 5 to 0 by -1) {
    val t = math.min(a/v(i), c_n(i))
    a -= t * v(i)
    ans += t
  }

  printf("Result : %d\n", ans)
}
