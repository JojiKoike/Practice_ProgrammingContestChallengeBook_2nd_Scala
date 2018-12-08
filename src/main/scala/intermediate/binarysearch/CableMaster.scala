package intermediate.binarysearch

object CableMaster extends App {
  import scala.io.StdIn._

  // Step 1 Get Inputs
  val N = readLine.toInt
  val K = readLine.toInt
  val L = readLine.split(" ").map(_.toDouble)

  // Step 2 Solve
  val judge = (x : Double) => L.map(_ / x).map(_.toInt).sum >= K
  var lb: Double  = 0.0
  var ub: Double = 100000000000.0
  val ESP: Double = 1.0e-10
  while (ub - lb > ESP) {
    val mid :Double = (lb + ub) / 2.0
    if (judge(mid)) {
      lb = mid
    } else {
      ub = mid
    }
  }

  // Step 3 Show Result
  printf("%.2f\n",math.floor(ub * 100) / 100)

}
