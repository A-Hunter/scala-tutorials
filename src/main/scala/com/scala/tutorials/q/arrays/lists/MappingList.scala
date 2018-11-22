package com.scala.tutorials.q.arrays.lists

/**
  * Created by Ghazi Naceur on 21/11/2018.
  */
object MappingList extends App {

  val a = List(1,2,3,4,5,6)

  a.map(x => println(x * x))

  val b = List("a","b","c","d","e")
  val res1 = b.map(_.toUpperCase()).flatten
  val res2 = b.flatMap(_.toUpperCase())
  // res1 & res2 are the same
  res1.foreach(x=> println(x))
  res2.foreach(x=> println(x))

  val c = Seq("Hello World")
  val res3 = c.flatMap(_.toUpperCase())
  res3.foreach(x=> println(x))
}
