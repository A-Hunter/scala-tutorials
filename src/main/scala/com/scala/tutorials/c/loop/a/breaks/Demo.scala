package com.scala.tutorials.c.loop.a.breaks

import scala.util.control.Breaks

/**
  * Created by Ghazi Naceur on 25/10/2018.
  */
object Demo {
  def main(args: Array[String]) {
    var a = 0
    val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val loop = new Breaks

    loop.breakable {
      for (a <- numList) {
        println("Value of a: " + a)

        if (a == 4) {
          loop.break
        }
      }
    }
    println("After the loop")
  }
}
