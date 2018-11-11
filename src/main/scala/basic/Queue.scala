package basic

import scala.collection.mutable

object Queue extends App {
  import scala.io.StdIn._

  val inputs = readLine.split(" ").map(_.toInt)
  val queue = new mutable.Queue[Int]

  for (input <- inputs) {
    queue.enqueue(input)
  }

  for (i <- queue.indices) {
    println(queue.dequeue())
  }
}
