package com.scala.tutorials.j.functions_with_named_arguments

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

/**
  * In a normal function call, the arguments in the call are matched one by one in the
  * order of the parameters of the called function. Named arguments allow you to pass
  * arguments to a function in a different order. The syntax is simply that each argument
  * is preceded by a parameter name and an equals sign.
  */
object Demo {
  def main(args: Array[String]) {
    printInt(b = 5, a = 7) // a = 7 & b = 5
//    printInt(5, a = 7) // Error : a is already specified a = 7
    printInt(5, b = 7) // a = 5 & b = 7
  }

  def printInt(a: Int, b: Int) = {
    println("Value of a : " + a)
    println("Value of b : " + b)
  }
}
