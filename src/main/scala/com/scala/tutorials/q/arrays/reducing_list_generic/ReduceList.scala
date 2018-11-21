package com.scala.tutorials.q.arrays.reducing_list_generic

/**
  * Created by Ghazi Naceur on 21/11/2018.
  */
object ReduceList extends App {

  val a = List(1,2,3,4,5,6)

  // arithmetic reduction operations
  println(a.max)
  println(a.min)
  println(a.sum)
  println(a.tail)
  println(a.head)
  println(a.product)

  // boolean reduction operations
  println(a.contains(1))
  println(a.contains(0))
  println(a.contains(1,2,0))
  println(a.endsWith(List(1,2,0)))
  println(a.endsWith(List(4,5,6)))
  println(a.exists(_<7))
  println(a.exists(_>7))
  println(a.exists(_>3))
  println(a.forall(_>3))
  println(a.forall(_<3))
  println(a.startsWith(List(1,3,5)))
  println(a.startsWith(List(1,2,3)))


}
