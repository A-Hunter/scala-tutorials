package com.scala.tutorials.u.exception_handling

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

object Demo2 {
  def main(args: Array[String]) {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }

      case ex: IOException => {
        println("IO Exception")
      }
    } finally {
      println("Exiting finally...")
    }
  }
}