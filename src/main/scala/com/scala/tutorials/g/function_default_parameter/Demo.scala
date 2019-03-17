package com.scala.tutorials.g.function_default_parameter

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

object Demo {
  def main(args: Array[String]) {
    println("Returned Value : " + addInt()) // a = 5, b = 7
    println("Returned Value : " + addInt(1, 2)) // a = 1, b = 2
    println("Returned Value : " + addInt(2)) // a = 2, b = 7
  }

  def addInt(a: Int = 5, b: Int = 7): Int = {
    a + b
  }
}
