package basic.fullsearch

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object MazeShortestPath extends App {
  import scala.io.StdIn._

  val INF = -10000000
  val dx = Array(1, 0, -1, 0)
  val dy = Array(0, 1, 0, -1)

  // Get Maze Size
  val Array(n, m) = readLine.split(" ").map(_.toInt)

  // Get Maze Data
  val rows = for (i <- 0 until n) yield readLine.split("")

  // Create Maze Table Data
  val maze = ArrayBuffer.empty[Array[String]]
  for (row <- rows) maze.append(row)

  var sx = 0
  var sy = 0
  var gx = 0
  var gy = 0

  // Get Start and Goal Coordinate Value
  for (i <- 0 until n) {
    for (j <- 0 until m) {
      if (maze(i)(j) == "S") {
        sx = j
        sy = i
      } else if (maze(i)(j) == "G") {
        gx = j
        gy = i
      }
    }
  }

  printf("Distance : %d\n", bfs())

  def bfs(): Int = {
    case class Pair(x: Int, y: Int)
    val queue = new mutable.Queue[Pair]

    // Initialize Distance Table
    val distance = ArrayBuffer.empty[Array[Int]]
    for (i <- 0 until n) {
      val row = ArrayBuffer.empty[Int]
      for (j<- 0 until m) {
        row.append(INF)
      }
      distance.append(row.toArray)
    }

    // Enqueue Starting Point
    queue.enqueue(Pair(sx, sy))
    distance(sy)(sx) = 0

    while (queue.nonEmpty) {
      val p = queue.dequeue()
      if (p.x == gx && p.y == gy) {
        queue.clear()
      } else {
        for (i <- 0 until 4) {
          val nx = p.x + dx(i)
          val ny = p.y + dy(i)
          if (0 <= nx && nx < m && 0 <= ny && ny < n && maze(ny)(nx) != "#" && distance(ny)(nx) == INF) {
            queue.enqueue(Pair(nx, ny))
            distance(ny)(nx) = distance(p.y)(p.x) + 1
          }
        }
      }
    }
    distance(gy)(gx)
  }
}

