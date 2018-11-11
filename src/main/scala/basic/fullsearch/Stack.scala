package basic.fullsearch

import scala.collection.mutable

object Stack extends App {

  import scala.io.StdIn._

  val inputs = readLine.split( " " ).map( _.toInt )
  val stack = new mutable.ArrayStack[Int]()

  for (input <- inputs) {
    stack.push(input)
  }

  for (i <- stack.indices) {
    println(stack.pop())
  }

}
