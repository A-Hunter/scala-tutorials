package com.scala.tutorials.j.functions_with_named_arguments

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */
object Demo {
  def main(args: Array[String]) {
    printInt(b = 5, a = 7)
  }

  def printInt( a:Int, b:Int ) = {
    println("Value of a : " + a )
    println("Value of b : " + b )
  }
}
