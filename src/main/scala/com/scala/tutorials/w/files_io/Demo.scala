package com.scala.tutorials.w.files_io

import java.io._

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */
object Demo {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("test.txt" ))
    writer.write("Hello Scala")
    writer.close()
  }
}
