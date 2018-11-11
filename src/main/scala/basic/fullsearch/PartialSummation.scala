package basic.fullsearch

object PartialSummation extends App {
  import scala.io.StdIn._

  val n = readLine.toInt
  val a = readLine.split(" ").map(_.toInt)
  val k = readLine.toInt

  println(if (dfs(0,0)) "Yes" else "No")

  def dfs(i: Int, sum: Int): Boolean = {
    if (i == n) return sum == k
    if (dfs(i + 1, sum)) return true
    if (dfs(i + 1, sum + a(i))) return true
    false
  }

}
