package com.scala.tutorials.r.traits.geometry

/**
  * Created by Ghazi Naceur on 24/11/2018.
  */
class Rectangle(height: Int, width: Int) extends Shape {
  override def name: String = "Rectangle"

  override def area: Int = height * width
}

object Main extends App {
  private val rectangle = new Rectangle(8, 5)
  println(rectangle.name)
  println(rectangle.area)
}