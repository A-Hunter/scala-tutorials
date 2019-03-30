package com.scala.lang.org.z3.default_parameter_values

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

class Point(val x: Double = 0, val y: Double = 0)

object DefaultParameterValues extends App {
  def log(message: String, level: String = "INFO") = println(s"$level: $message")
  log("System starting")  // prints INFO: System starting
  log("User not found", "WARNING")  // prints WARNING: User not found

  val point1 = new Point(y = 1)
}