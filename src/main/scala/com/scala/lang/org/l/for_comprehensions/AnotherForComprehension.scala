package com.scala.lang.org.l.for_comprehensions

/**
  * Created by Ghazi Naceur on 24/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object AnotherForComprehension extends App {

  def foo(n: Int, v: Int) =
    for (i <- 0 until n; j <- i until n if i + j == v)
      yield (i, j)

  foo(10, 10) foreach {
    case (i, j) =>
      print(s"($i, $j) ")  // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
  }
}
