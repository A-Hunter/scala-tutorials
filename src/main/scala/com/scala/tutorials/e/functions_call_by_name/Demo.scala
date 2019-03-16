package com.scala.tutorials.e.functions_call_by_name

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

/**
  * Typically, parameters to functions are by-value parameters; that is, the value of
  * the parameter is determined before it is passed to the function. But what if we
  * need to write a function that accepts as a parameter an expression that we don't
  * want evaluated until it's called within our function? For this circumstance, Scala
  * offers call-by-name parameters.
  * A call-by-name mechanism passes a code block to the call and each time the call
  * accesses the parameter, the code block is executed and the value is calculated.
  * Here, delayed prints a message demonstrating that the method has been entered.
  * Next, delayed prints a message with its value. Finally, delayed returns ‘t’.
  */
object Demo {
  def main(args: Array[String]) {
    println(" >>> Call by name :")
    delayed(time())

    println(" ------ ")
    println(" >>> Call by value :")
    println(callByValue(time()))
    println(" ------ ")
    println(" >>> Call by name :")
    println(callByName(time()))
  }

  def time() = {
    println("Getting time in nano seconds") // 2nd to be executed
    System.nanoTime // 3rd to be executed
  }

  def delayed(t: => Long) = {
    println("In delayed method") // 1st to be executed
    println("Param: " + t) // 4th to be executed
  }

  def callByValue(t: Long): Long = {
    println("Entered callByValue, calling t ...")
    println("t = " + t)
    println("Calling t again ...")
    t
  }

  //  The argument t is not evaluated at the point of function application, but instead is evaluated at each use within
  //    the function. That is, the argument is evaluated using call-by-name
  def callByName(t: => Long): Long = {
    println("Entered callByName, calling t ...")
    println("t = " + t)
    println("Calling t again ...")
    t
  }
}
