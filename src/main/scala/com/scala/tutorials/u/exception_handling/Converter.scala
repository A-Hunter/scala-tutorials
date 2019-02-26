package com.scala.tutorials.u.exception_handling

/**
  * Created by Ghazi Naceur on 22/11/2018.
  */
object Converter extends App {

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  println(toInt("5").get)
  println(toInt("X"))

  val strings = List("5", "2", "6", "8", "9", "p")
  val result1 = strings.map(toInt)
  println("result1 : " + result1)

  val result2 = strings.flatMap(toInt)
  println("result2 : " + result2)

  val result3 = strings.flatMap(toInt).sum
  println("result3 : " + result3)
}
