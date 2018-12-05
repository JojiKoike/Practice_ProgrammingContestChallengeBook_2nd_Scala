package basic.graph

import scala.collection.mutable.ArrayBuffer

object simplegraph extends  App {
  import scala.io.StdIn._

  // Edge Info Data Structure
  case class Edge(from: Int, to: Int, cost: Int)

  // Get number of  vertexes(e) and edges(e)
  val Array(v, e) = readLine.split(" ").map(_.toInt)

  // Get Connection Info
  val routeInfoInputs = for (i <- 0 until e) yield readLine.split(" ").map(_.toInt)
  val routes = new ArrayBuffer[Edge]()
  for (routeInfoInput <- routeInfoInputs) {
    routes.append(Edge(routeInfoInput(0), routeInfoInput(1), routeInfoInput(2)))
    // Reverse
    routes.append(Edge(routeInfoInput(1), routeInfoInput(0), routeInfoInput(2)))
  }

  // Show Edge Info
  routeInfoInputs.foreach(print)

}
