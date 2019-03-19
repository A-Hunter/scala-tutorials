package com.scala.tutorials.q.arrays.tuples

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * Scala tuple combines a fixed number of items together so that they can be passed around
  * as a whole. Unlike an array or list, a tuple can hold objects with different types but
  * they are also immutable.
  * The following is an example of a tuple holding an integer, a string, and the console.
  * val t = (1, "hello", Console)
  */
object Demo {
  def main(args: Array[String]) {

    val t = (4, 3, 2, 1)
    val sum = t._1 + t._2 + t._3 + t._4
    println("Sum of elements: " + sum)

    t.productIterator.foreach { i => println("Value = " + i) }

    val tup = Tuple3(1, "hello", Console)
    println("Concatenated String: " + tup.toString())

    val tuple = Tuple2("Scala", "hello")
    println("Swapped Tuple: " + tuple.swap)
  }
}
