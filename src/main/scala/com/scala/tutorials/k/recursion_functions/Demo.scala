package com.scala.tutorials.k.recursion_functions

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

/**
  * Recursion plays a big role in pure functional programming and Scala supports
  * recursion functions very well. Recursion means a function can call itself repeatedly.
  */
object Demo {
  def main(args: Array[String]) {
    for (i <- 1 to 10)
      println("Factorial of " + i + ": = " + factorial(i))
  }

  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }
}
