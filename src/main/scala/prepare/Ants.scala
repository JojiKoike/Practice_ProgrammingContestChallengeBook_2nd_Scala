package prepare

import scala.collection.mutable.ArrayBuffer

object Ants extends App {
  import scala.io.StdIn._

  val Array(l, n) = readLine.split(" ").map(_.toInt)
  val ants = readLine.split(" ").map(_.toInt)

  // Calc Time
  val buf_minT = new ArrayBuffer[Int]()
  val buf_maxT = new ArrayBuffer[Int]()
  for (ant <- ants) {
    buf_minT.append(Math.min(ant, l - ant))
    buf_maxT.append(Math.max(ant, l - ant))
  }
  println(buf_minT.toArray.max)
  println(buf_maxT.toArray.max)
}
