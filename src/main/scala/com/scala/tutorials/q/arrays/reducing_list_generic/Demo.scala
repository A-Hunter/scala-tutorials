package com.scala.tutorials.q.arrays.reducing_list_generic

/**
  * Created by Ghazi Naceur on 13/11/2018.
  */
object Demo extends App {

  val numbers = List(1,2,3)
  val ints = List(4,7,1,8,5)

  println(numbers.fold(0)(_ + _))
  // 0 is the starting value
  // is similar to : numbers.sum
  //is similar to  : numbers.fold(0)((x,y) => x+y)
  println(numbers.fold(0)((x, y) => x + y))
  println(numbers.sum)

  println(ints.foldLeft(0)(_ - _))
  println(ints.foldRight(0)(_ - _))
  println(ints.foldRight(0)((x, y) => {
    println(x)
    println(y)
    println("println(x-y)" + (x-y))
    x - y
  }))
}
