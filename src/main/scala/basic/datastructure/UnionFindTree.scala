package basic.datastructure

import scala.collection.mutable.ArrayBuffer

object UnionFindTree extends App {
  import scala.io.StdIn._

  var par = ArrayBuffer.empty[Int]
  var rank = ArrayBuffer.empty[Int]

  def init(n: Int): Unit = {
    for (i <- 0 until n) {
      par.append(i)
      rank.append(0)
    }
  }

  def find(x : Int): Int = {
    if (par(x) == x) {
      x
    } else {
      find(par(x))
    }
  }

  def unite(x: Int, y: Int): Unit = {
    val x_root = find(x)
    val y_root = find(y)
    if (x_root == y_root) return

    if (rank(x) < rank(y)) {
      par(x) = y
    } else {
      par(y) = x
      if (rank(x) == rank(y)) rank(x) += 1
    }
  }

  def same(x: Int, y: Int): Boolean = {
    find(x) == find(y)
  }
}
