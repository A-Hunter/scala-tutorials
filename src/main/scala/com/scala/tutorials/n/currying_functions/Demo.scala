package com.scala.tutorials.n.currying_functions

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

/**
  * Currying transforms a function that takes multiple parameters into a chain of functions, each taking a single
  * parameter. Curried functions are defined with multiple parameter lists, as follows −
  *
  * Syntax
  * def strcat(s1: String)(s2: String) = s1 + s2
  * Alternatively, you can also use the following syntax to define a curried function −
  *
  * Syntax
  * def strcat(s1: String) = (s2: String) => s1 + s2
  * Following is the syntax to call a curried function −
  *
  * Syntax
  * strcat("foo")("bar")
  */
object Demo {
  def main(args: Array[String]) {
    val str1: String = "Hello, "
    val str2: String = "Scala!"

    println("str1 + str2 = " + strcat(str1)(str2))
  }

  def strcat(s1: String)(s2: String): String = {
    s1 + s2
  }
}