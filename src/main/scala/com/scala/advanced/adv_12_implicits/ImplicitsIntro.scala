package com.scala.advanced.adv_12_implicits

object ImplicitsIntro extends App {

  val pair = "Netero" -> "1"
  val intPair = 1 -> 2 // "->" is an implicit method

  case class Person(name: String) {
    def greet = s"Hi ! My name is $name"
  }

  implicit def fromStringToPerson(string: String): Person = Person(string)
  println("Itachi".greet) // .greet is not a member of the String class, but thanks to the method "fromStringToPerson",
  // we added new features to String class

  def increment(x: Int)(implicit amount: Int): Int = x + amount
  implicit val defaultAmount: Int = 100

  // Implicitly by the compiler, the value of "defaultAmount" will be passed to "amount" of the method "increment"
  println(increment(2))
}
