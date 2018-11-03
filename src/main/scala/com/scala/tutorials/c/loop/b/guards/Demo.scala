package com.scala.tutorials.c.loop.b.guards

/**
  * Created by Ghazi Naceur on 03/11/2018.
  */

/**
  * Guards or Filters
  */
object Demo {

  def main(args: Array[String]): Unit = {
    for (a <- 1 until 10 if a % 2 == 0) yield println(a)
  }
}
