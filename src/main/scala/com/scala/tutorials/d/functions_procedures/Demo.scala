package com.scala.tutorials.d.functions_procedures

/**
  * Created by Ghazi Naceur on 25/10/2018.
  */
object Demo {
  def main(args: Array[String]) {
    printMe()
    println("Returned Value : " + addInt(5, 7))
  }

  // function
  def addInt(a: Int, b: Int): Int = {
    var sum: Int = 0
    sum = a + b
    sum
    // We can write :
    // sum
    //  or
    // return sum
    // The "return" keyword is not compulsory
  }

  // procedure
  def printMe(): Unit = {
    println("Hello, Scala!")
  }
}
