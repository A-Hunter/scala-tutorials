package com.scala.tutorials.p.strings

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */
object Demo {
  def main(args: Array[String]) {
    val name = "James"

    /**
      * The literal ‘s’ allows the usage of variable directly in processing a string,
      * when you prepend ‘s’ to it. Any String variable with in a scope that can be
      * used with in a String. The following are the different usages of ‘s’ String
      * interpolator.
      * The following example code snippet for the implementation of ‘s’ interpolator
      * in appending String variable ($name) to a normal String (Hello) in println statement.
      * val name = “James”
      * println(s “Hello, $name”) //output: Hello, James
      */
    println(s"Hello, $name")
    println(s"1 + 1 = ${1 + 1}")


    /**
      * The literal ‘f’ interpolator allows to create a formatted String, similar to
      * printf in C language. While using ‘f’ interpolator, all variable references
      * should be followed by the printf style format specifiers such as %d, %i, %f, etc.
      * Let us take an example of append floating point value (height = 1.9d) and
      * String variable (name = “James”) with normal string. The following code snippet
      * of implementing ‘f’ Interpolator. Here $name%s to print (String variable)
      * James and $height%2.2f to print (floating point value) 1.90.
      */
    val height = 1.9d
    println(f"$name%s is $height%2.2f meters tall") //James is 1.90 meters tall


    /**
      * The ‘raw’ interpolator is similar to ‘s’ interpolator except that it performs
      * no escaping of literals within a string. The following code snippets in a table
      * will differ the usage of ‘s’ and ‘raw’ interpolators. In outputs of ‘s’ usage ‘\n’
      * effects as new line and in output of ‘raw’ usage the ‘\n’ will not effect.
      * It will print the complete string with escape letters.
      */
    println(raw"Result = \n a \n b")
  }
}