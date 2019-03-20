package com.scala.lang.org.c.class_composition_with_mixins

/**
  * Created by Ghazi Naceur on 19/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

//  Classes can only have one superclass but many mixins (using the keywords extends and with respectively).
//  The mixins and the superclass may have the same supertype.
abstract class A {
  val message: String
}

class B extends A {
  override val message: String = "This is an instance of Class B"
}

trait C extends A {
  val loudMessage: String = message.toUpperCase
}

//Mixins are traits which are used to compose a class: (trait C)
class D extends B with C

object A extends App {
  val d = new D
  println(d.message)
  println(d.loudMessage)
}