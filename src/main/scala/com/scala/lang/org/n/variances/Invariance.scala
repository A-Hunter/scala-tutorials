package com.scala.lang.org.n.variances

/**
  * Created by Ghazi Naceur on 25/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

class Container[A](value: A) {
  private var _value: A = value
  def getValue: A = _value
  def setValue(value: A): Unit = {
    _value = value
  }
}

object Invariance extends App {
  //  Generic classes in Scala are invariant by default. This means that they are neither covariant nor
  //  contravariant. In the context of the following example, Container class is invariant.
  //  A Container[Cat] is not a Container[Animal], nor is the reverse true.

  val catContainer: Container[Cat] = new Container(Cat("Felix"))
//  val animalContainer: Container[Animal] = catContainer
//  animalContainer.setValue(Dog("Spot"))
//  val cat: Cat = catContainer.getValue // Oops, we'd end up with a Dog assigned to a Cat
}
