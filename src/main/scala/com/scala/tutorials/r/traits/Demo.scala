package com.scala.tutorials.r.traits

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * A trait encapsulates method and field definitions, which can then be reused by
  * mixing them into classes. Unlike class inheritance, in which each class must
  * inherit from just one superclass, a class can mix in any number of traits.
  * Traits are used to define object types by specifying the signature of the supported
  * methods. Scala also allows traits to be partially implemented but traits may not
  * have constructor parameters.
  * A trait definition looks just like a class definition except that it uses the
  * keyword trait. The following is the basic example syntax of trait.
  */
trait Equal {
  def isEqual(x: Any): Boolean

  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class Point(xc: Int, yc: Int) extends Equal {
  var x: Int = xc
  var y: Int = yc

  def isEqual(obj: Any): Boolean = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y
}

object Demo {
  def main(args: Array[String]) {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))
  }
}
