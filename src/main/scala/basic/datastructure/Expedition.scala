package basic.datastructure

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Expedition extends App {
  import scala.io.StdIn._

  // Get Input Values
  val Array(n, l, p) = readLine.split(" ").map(_.toInt)
  val a = readLine.split(" ").map(_.toInt)
  val b = readLine.split(" ").map(_.toInt)

  // Build Supply Station Info Array
  val A = ArrayBuffer.empty[Int]
  val B = ArrayBuffer.empty[Int]
  for (i <- a.indices) {
    A.append(a(i))
    B.append(b(i))
  }
  A.append(l)
  B.append(0)

  val pq = new mutable.PriorityQueue[Int]()

  var ans = 0
  var curPos = 0
  var tank = p
  var isEmpty = false

  for (i <- a.indices if !isEmpty) {
    val d = a(i) - curPos
    while (tank - d < 0 && !isEmpty) {
      if (pq.isEmpty) {
        isEmpty = true
      } else {
        tank += pq.dequeue()
        ans += 1
      }
    }
    if (!isEmpty) {
      tank -= d
      curPos = a(i)
      pq.enqueue(b(i))
    }
  }
  println(if (isEmpty) -1 else ans)
}
