package com.scala.tutorials.c.loop_breaks

/**
  * Created by Ghazi Naceur on 25/10/2018.
  */
object ForLoop {
  def main(args: Array[String]) {
    var a = 0


    for (a <- 1 until 10) yield println(a)

    for (a <- 1 until 10) println(a)

    // (a <- 1 until 10) ==> 1,2,3,4,5,6,7,8,9
    // (a <- 1 to 10)    ==> 1,2,3,4,5,6,7,8,9,10

    // for loop execution with a range
    for (a <- 1 until 10) {
      println("Value of a: " + a)
    }
  }
}
