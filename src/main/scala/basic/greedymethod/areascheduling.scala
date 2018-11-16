package basic.greedymethod

import scala.collection.mutable

object areascheduling extends App {
  import scala.io.StdIn._

  // Get Inputs
  val n = readLine.toInt
  val s = readLine.split(" ").map(_.toInt)
  val t = readLine.split(" ").map(_.toInt)

  // Build Task Queue (using Priority Queue order by end asc)
  val taskpq = new mutable.PriorityQueue[Task]()(Ordering.by(orderTask))
  case class Task(start: Int, end: Int)
  def orderTask(task: Task): Int = -task.end
  for (i <- s.indices) {
    taskpq.enqueue(Task(s(i), t(i)))
  }

  // Solve
  var ans : Int = 0
  var term : Int = 0
  for (i <- 0 until n) {
    val task = taskpq.dequeue()
    if (term < task.start) {
      ans += 1
      term = task.end
    }
  }
  printf("Result : %d\n", ans)
}
