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
    delayed(time())
  }

  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }
  def delayed(t: => Long) = {
    println("In delayed method")
    println("Param: " + t)
  }
}
