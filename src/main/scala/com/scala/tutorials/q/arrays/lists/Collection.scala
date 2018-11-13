package com.scala.tutorials.q.arrays.lists

import scala.collection.mutable.ListBuffer

/**
  * Created by Ghazi Naceur on 08/11/2018.
  */
object Collection extends App {

  val numbers = List(12,23,45,56,78,89)

  val strings = ListBuffer[String]()

  var total = 0

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

  for (i <- numbers){
    total += i
  }
  println("Total = " + total)

  // Range
  val integers = List.range(1,10)
  integers.foreach(i => println(i))

  val integersWithStep = List.range(1,10,3)
  integersWithStep.foreach(i => println(i))

  // Fill
  val dup = List.fill(3)("Hello")
  println(dup)
}
