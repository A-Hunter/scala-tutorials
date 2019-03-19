package com.scala.tutorials.w.files_io

import scala.io.StdIn

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */
object Demo2 {
  def main(args: Array[String]) {
    print("Please enter your input : ")
    val line = Console.readLine
    // Console.readLine is deprecated .. We can use StdIn.readLine
    val secondLine = StdIn.readLine()
    println("Thanks, you just typed : " + line)
    println("Thanks again, you wrote : " + secondLine)
  }
}
