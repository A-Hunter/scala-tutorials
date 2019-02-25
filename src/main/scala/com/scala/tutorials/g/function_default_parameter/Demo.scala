package com.scala.tutorials.g.function_default_parameter

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

object Demo {
  def main(args: Array[String]) {
    println("Returned Value : " + addInt())
  }

  def addInt(a: Int = 5, b: Int = 7): Int = {
    var sum: Int = 0
    sum = a + b

    return sum
  }
}
