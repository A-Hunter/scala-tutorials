package com.scala.lang.org.a.classes

/**
  * Created by Ghazi Naceur on 19/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
class AnotherPoint {
  private var _x: Int = 0
  private var _y: Int = 0

  // Getters
  def x: Int = _x

  def y: Int = _y

  // Setters
  def x_=(newValue: Int): Unit = {
    _x = newValue
  }

  def y_=(newValue: Int): Unit = {
    _y = newValue
  }
}

object AnotherPoint {
  def main(args: Array[String]): Unit = {
    val point: AnotherPoint = new AnotherPoint
    point.x_=(5)
    point.y_=(7)

    println(point.x)
    println(point.y)
  }
}
