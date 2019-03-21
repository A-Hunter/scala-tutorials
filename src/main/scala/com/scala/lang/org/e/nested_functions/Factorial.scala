package com.scala.lang.org.e.nested_functions

/**
  * Created by Ghazi Naceur on 21/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object Factorial {

  def factorial(number: Int): Int = {
    def fact(n: Int, acc: Int): Int = {
      if (n <= 1) {
        acc
      } else {
        fact(n - 1, acc * n)
      }
    }
    fact(number, 1)
  }

  def main(args: Array[String]): Unit = {
    println(factorial(4))
  }
}
