package basic.fullsearch

import scala.collection.mutable.ArrayBuffer

object LakeCounting extends App {
  import scala.io.StdIn._

  // Get MapSize
  val Array(n, m) = readLine.split(" ").map(_.toInt)

  // Get Map Data
  val rows = for (i <- 0 until n) yield readLine.split("")

  // Create Map Table Data
  val map = ArrayBuffer.empty[Array[String]]
  for (row <- rows)  map.append(row)

  // Lake Counting
  var count = 0
  for (i <- 0 until n) {
    for (j <- 0 until m) {
      if (map(i)(j) == "W") {
        dfs(i, j)
        count += 1
      }
    }
  }
  printf("%d Lakes found\n", count)


  // Depth First Search
  def dfs(i: Int, j: Int): Unit = {
    map(i)(j) = "."
    for (dy <- -1 to 1) {
      for (dx <- -1 to 1) {
        val ny = i + dy
        val nx = j + dx
        if (0 <= nx && nx < m && 0 <= ny && ny < n && map(ny)(nx) == "W") dfs(ny, nx)
      }
    }
  }
}
