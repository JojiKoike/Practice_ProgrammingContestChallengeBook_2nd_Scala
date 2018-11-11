package basic.fullsearch

object Fact extends App {
  import scala.io.StdIn._

  val n = readLine.toInt
  println(fact(n))

  def fact(n: Int): Int = {
    if (n == 0) {
      1
    } else {
      fact( n - 1 ) * n
    }
  }

}
