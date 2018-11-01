package prepare

import scala.collection.mutable.ListBuffer

object Triangle extends App {
  import scala.io.StdIn._

  val n = readLine.toInt
  val parts = readLine.split(",").map(_.toInt)

  val anslist = new ListBuffer[Int]

  for (i <- 0 until n) {
    for (j <- i + 1 until n) {
      for (k <- j + 1 until n) {
        val totallen = parts(i) + parts(j) + parts(k)
        val maxlen = Math.max(parts(i), Math.max(parts(j), parts(k)))
        if (maxlen < totallen - maxlen) {
          anslist.append(totallen)
        }
      }
    }
  }
  println(anslist.toList.max)
}
