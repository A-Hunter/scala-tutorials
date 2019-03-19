package com.scala.lang.org.b.traits

/**
  * Created by Ghazi Naceur on 19/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
trait Iterator[A] {
  def hasNext: Boolean

  def next(): A
}

class IntIterator(limit: Int) extends Iterator[Int] {
  var current: Int = 0

  override def hasNext: Boolean = current < limit

  override def next(): Int = {
    if (hasNext) {
      val iterator = current
      current += 1
      iterator
    } else 0
  }
}

object Iterator {
  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)
    println(iterator.next()) // prints 0
    println(iterator.next()) // prints 1
    println(iterator.next()) // prints 2
    println(iterator.next()) // prints 3
    println(iterator.next()) // prints 4
    println(iterator.next()) // prints 5
    println(iterator.next()) // prints 6
    println(iterator.next()) // prints 7
    println(iterator.next()) // prints 8
    println(iterator.next()) // prints 9
    println(iterator.next()) // prints 0
  }
}