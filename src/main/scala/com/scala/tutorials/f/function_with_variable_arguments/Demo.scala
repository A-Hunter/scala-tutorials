package com.scala.tutorials.f.function_with_variable_arguments

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

/**
  * Scala allows you to indicate that the last parameter to a function may be repeated.
  * This allows clients to pass variable length argument lists to the function.
  * Here, the type of args inside the print Strings function, which is declared as type
  * "String*" is actually Array[String].
  */
object Demo {
  def main(args: Array[String]) {
    printStrings("Hello", "Scala", "Python")
  }

  def printStrings(args:String*) = {
    var i : Int = 0

    for(arg <- args){
      println("Arg value[" + i + "] = " + arg)
      i = i + 1
    }
  }
}
