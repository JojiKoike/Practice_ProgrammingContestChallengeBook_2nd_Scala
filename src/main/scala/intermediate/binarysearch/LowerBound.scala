package intermediate.binarysearch

object LowerBound extends App {
  import scala.io.StdIn._

  // Get Inputs
  val Array(n, k) = readLine.split(" ").map(_.toInt)
  val a = readLine.split(" ").map(_.toInt)

  var lb = -1
  var ub = n
  while (ub - lb > 1) {
    val mid = (lb + ub) / 2
    if (a(mid) >= k) {
      ub = mid
    } else {
      lb = mid
    }
  }

  printf("Result : %d\n", ub)
}
