package com.scala.tutorials.q.arrays.scan_operation

/**
  * Created by Ghazi Naceur on 15/11/2018.
  */
object Operation extends App {

  val divide = (x: Double, y: Double) =>{
    val result = x/y
    result
  }

  val a = List(1.0,2.0,3.0)

  println(a.reduceLeft(divide))
  println(a.reduceLeftOption(divide))
  println(a.reduceRight(divide))
  println(a.reduceRightOption(divide))


  val product = (x: Int, y: Int) => {
    val result = x*y
    result
  }

  val b = Array(1,2,3)

  val arr = b.scanLeft(10)(product)
  arr.foreach(a=>println(a))
  println("*****")
  val abb = b.scanRight(10)(product)
  abb.foreach(a=> println(a))
  println("*****")

  val c = Array(1,2,3)
  println(c.foldLeft(1)(product))
  println(c.foldRight(1)(product))
}
