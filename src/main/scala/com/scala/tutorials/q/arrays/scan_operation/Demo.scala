package com.scala.tutorials.q.arrays.scan_operation

/**
  * Created by Ghazi Naceur on 15/11/2018.
  */

/**
  * In general, all 6 fold functions apply a binary operator to each element of a collection.
  * The result of each step is passed on to the next step (as input to one of the binary operator's
  * two arguments). This way we can cumulate a result.
  * reduceLeft and reduceRight cumulate a single result.
  * foldLeft and foldRight cumulate a single result using a start value.
  * scanLeft and scanRight cumulate a collection of intermediate cumulative results using a start value.
  */
object Demo extends App {

  val ints = List(4, 7, 1, 8, 5)

  println(ints.reduce(_ - _))
  println(ints.reduceLeft(_ - _))
  println(ints.reduceRight(_ - _))

  println(ints.fold(0)(_ - _))
  println(ints.foldLeft(0)(_ - _))
  println(ints.foldRight(0)(_ - _))

  println(ints.scan(0)(_ - _))
  println(ints.scanLeft(0)(_ - _))
  println(ints.scanRight(0)(_ - _))
    println(ints.scanRight(0)((x, y) => {
      println(x)
      println(y)
      println("println(x-y)" + (x-y))
      x - y
    }))

}
