package com.scala.lang.org.classes

/**
  * Created by Ghazi Naceur on 19/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

// Parameters without val or var are private values, visible only within the class.
class Point(val x: Int = 0, val y: Int = 0) {
}

object Main {
  def main(args: Array[String]): Unit = {
    val point = new Point(3) // x = 1
    println(point.x)

    val point2 = new Point(y = 5)
    println(point2.y)
  }
}
