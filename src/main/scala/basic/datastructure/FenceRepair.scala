package basic.datastructure

import scala.collection.mutable

object FenceRepair extends App {
  import scala.io.StdIn._

  // Get Input Values
  val n = readLine.toInt  // Number of pieces
  val L = readLine.split(" ").map(_.toInt) // Length of each pieces

  // Build Priority Queue
  val pq = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
  L.foreach(pq.enqueue(_))

  // Solve
  var ans = 0
  while(pq.size > 1) {
    val l1 = pq.dequeue()
    val l2 = pq.dequeue()
    ans += l1 + l2
    pq.enqueue(ans)
  }

  // Show Result
  printf("Result %d\n", ans)
}
