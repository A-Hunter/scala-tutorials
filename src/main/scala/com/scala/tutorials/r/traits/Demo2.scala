package com.scala.tutorials.r.traits

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * Value classes are new mechanism in Scala to avoid allocating runtime objects.
  * It contains a primary constructor with exactly one val parameter. It contains
  * only methods (def) not allowed var, val, nested classes, traits, or objects.
  * Value class cannot be extended by another class. This can be possible by extending
  * your value class with AnyVal. The typesafety of custom datatypes without the
  * runtime overhead.
  * Let us take an examples of value classes Weight, Height, Email, Age, etc.
  * For all these examples it is not required to allocate memory in the application.
  * A value class not allowed to extend traits. To permit value classes to extend traits,
  * universal traits are introduced which extends for Any.
  *
  *
  * When to Use Traits?
  * There is no firm rule, but here are few guidelines to consider −
  * If the behavior will not be reused, then make it a concrete class. It is not reusable
  * behavior after all.
  * If it might be reused in multiple, unrelated classes, make it a trait. Only traits can
  * be mixed into different parts of the class hierarchy.
  * If you want to inherit from it in Java code, use an abstract class.
  * If you plan to distribute it in compiled form, and you expect outside groups to write
  * classes inheriting from it, you might lean towards using an abstract class.
  * If efficiency is very important, lean towards using a class.
  */
trait Printable extends Any {
  def print(): Unit = println(this)
}

class Wrapper(val underlying: Int) extends AnyVal with Printable

object Demo2 {
  def main(args: Array[String]) {
    val w = new Wrapper(3)
    w.print() // actually requires instantiating a Wrapper instance
  }
}
