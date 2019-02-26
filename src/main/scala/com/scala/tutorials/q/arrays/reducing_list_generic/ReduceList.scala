package com.scala.tutorials.q.arrays.reducing_list_generic

/**
  * Created by Ghazi Naceur on 21/11/2018.
  */
object ReduceList extends App {

  val a = List(1, 2, 3, 4, 5, 6)

  // arithmetic reduction operations
  println("Max : " + a.max)
  println("Min : " + a.min)
  println("Sum : " + a.sum)
  println("Tail : " + a.tail)
  println("Head : " + a.head)
  println("Product : " + a.product)

  // boolean reduction operations
  println("Contains 1 : " + a.contains(1))
  println("Contains 0 : " + a.contains(0))
  println("Contains 1,2,0 : " + a.contains(1, 2, 0))
  println("Ends with list 1,2,0 : " + a.endsWith(List(1, 2, 0)))
  println("Ends with list 4,5,6 : " + a.endsWith(List(4, 5, 6)))
  println("Exists inferior to 7 : " + a.exists(_ < 7))
  println("Exists superior to 7 : " + a.exists(_ > 7))
  println("Exists superior to 3 : " + a.exists(_ > 3))
  println("Forall superior to 3 : " + a.forall(_ > 3))
  println("Forall inferior to 3 : " + a.forall(_ < 3))
  println("Starts with list 1,3,5 : " + a.startsWith(List(1, 3, 5)))
  println("Starts with list 1,2,3 : " + a.startsWith(List(1, 2, 3)))


}
