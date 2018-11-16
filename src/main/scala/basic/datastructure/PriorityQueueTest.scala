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

  // Build Task Queue
  val taskqueue = new mutable.PriorityQueue[Task]()(Ordering.by(taskOrder))
  val n = readLine.toInt
  val tasks = for (i <- 0 until n) yield readLine.split(" ").map(_.toInt)
  for (task <- tasks) {
    taskqueue.enqueue(Task(task(0), task(1)))
  }
  taskqueue.dequeueAll.foreach(println)

  case class Task(start: Int, end: Int)
  def taskOrder(task : Task) : Int = -task.end

}



