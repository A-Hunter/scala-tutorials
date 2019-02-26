package com.scala.tutorials.u.exception_handling

/**
  * Created by Ghazi Naceur on 22/11/2018.
  */
object Demo3 extends App {

  def list(v: Int) = List(v - 1, v, v + 1)

  private val result: List[Int] = list(2)
  println(result)
  println(result.sum)

  val numbers = List(1, 2, 3, 4, 5)
  println(numbers.map(x => list(x)))
  println(numbers.flatMap(x => list(x)))
}
