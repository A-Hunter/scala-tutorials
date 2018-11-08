package com.scala.tutorials.q.arrays.lists

import scala.collection.mutable.ListBuffer

/**
  * Created by Ghazi Naceur on 08/11/2018.
  */
object Collection extends App {

  val numbers = List(12,23,45,56,78,89)

  val strings = ListBuffer[String]()

  strings += "one"
  strings += "two"
  strings += "three"
  strings += "four"
  strings += "five"
  strings += "six"

  println(strings)
  println(strings.toList)
  println(strings.toList.head)
  println(strings.toList.tail)


}
