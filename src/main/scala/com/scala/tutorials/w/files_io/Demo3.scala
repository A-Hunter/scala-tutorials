package com.scala.tutorials.w.files_io

import scala.io.Source

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

object Demo3 {
  def main(args: Array[String]) {
    println("Following is the content read:")

    Source.fromFile("test.txt").foreach {
      print
    }
  }
}
