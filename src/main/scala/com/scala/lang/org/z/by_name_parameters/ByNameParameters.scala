package com.scala.lang.org.z.by_name_parameters

/**
  * Created by Ghazi Naceur on 29/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
//By-name parameters are only evaluated when used. They are in contrast to by-value parameters.
// To make a parameter called by-name, simply prepend => to its type.
object ByNameParameters extends App {
  def calculate(input: => Int) = input * 37

  def whileLoop(condition: => Boolean)(body: => Unit): Unit =
    if (condition) {
      body // => () ==> This function does nothing
      whileLoop(condition)(body)
    }
  var i = 2
  whileLoop (i > 0) {
    println(i)
    i -= 1
  }  // prints 2 1

  /**
  The method whileLoop uses multiple parameter lists to take a condition and a body of the loop.
  If the condition is true, the body is executed and then a recursive call to whileLoop is made.
  If the condition is false, the body is never evaluated because we prepended => to the type of body.

  Now when we pass i > 0 as our condition and println(i); i-= 1 as the body, it behaves like the
  standard while loop in many languages.

  This ability to delay evaluation of a parameter until it is used can help performance if the
  parameter is computationally intensive to evaluate or a longer-running block of code such as
  fetching a URL.
    */
}
