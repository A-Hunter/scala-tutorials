package com.scala.tutorials.u.exception_handling

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * Scala's exceptions work like exceptions in many other languages like Java.
  * Instead of returning a value in the normal way, a method can terminate by throwing
  * an exception. However, Scala doesn't actually have checked exceptions.
  * When you want to handle exceptions, you use a try{...}catch{...} block like you
  * would in Java except that the catch block uses matching to identify and handle
  * the exceptions.
  *
  * Scala allows you to try/catch any exception in a single block and then perform
  * pattern matching against it using case blocks. Try the following example program
  * to handle exception.
  */
object Demo {
  def main(args: Array[String]) {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException =>{
        println("Missing file exception")
      }

      case ex: IOException => {
        println("IO Exception")
      }
    }
  }
}
