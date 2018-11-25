package com.scala.tutorials.r.traits.geometry

/**
  * Created by Ghazi Naceur on 25/11/2018.
  */
class RightAngleTriangle(adjacent: Int, opposite: Int) extends Triangle {
  override def isRightAngle: Boolean = true

  override def area: Int = (adjacent * opposite)/2

  override def name: String = "Right Angle Triangle"
}

object TriangleMain {
  def main(args: Array[String]): Unit = {
    val triangle = new RightAngleTriangle(5, 10)
    println(triangle.name)
    println(triangle.isRightAngle)
    println(triangle.area)
  }
}