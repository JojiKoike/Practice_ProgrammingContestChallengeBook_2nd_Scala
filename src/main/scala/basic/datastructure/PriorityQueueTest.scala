package basic.datastructure

import scala.collection.mutable

object PriorityQueueTest extends App {
  import scala.io.StdIn._

  // Descending Order (It's Default)
  val pq_desc = new mutable.PriorityQueue[Int]()

  // Ascending Order
  val pq_asc = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

  // Input values
  val inputs = readLine.split(" ").map(_.toInt)

  // Enqueue inputted values
  inputs.foreach(pq_desc.enqueue(_))
  inputs.foreach(pq_asc.enqueue(_))

  // Dequeue All enqueued data and print
  pq_desc.dequeueAll.mkString(" ").foreach(print)
  println()
  pq_asc.dequeueAll.mkString(" ").foreach(print)

}
