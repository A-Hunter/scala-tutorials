package com.scala.advanced.adv_12_implicits

import com.scala.advanced.adv_12_implicits.TypeClasses.HTMLWritable

object EqualityExample extends App {

  case class User(name: String, age: Int, email: String) extends HTMLWritable {
    override def toHTML: String = s"<div>$name ($age yo) <a href=$email/> </div>"
  }

  val isaac = User("Isaac", 125, "isaac.netero@hunter.com")
  val netero = User("Netero", 125, "isaac.netero@hxh.com")

  // Type class example
  trait Equal[T] {
    def equal(value1: T, value2: T): Boolean
  }

  implicit object NameEquality extends Equal[User] {
    override def equal(value1: User, value2: User): Boolean = value1.name == value2.name
  }

  object FullEquality extends Equal[User] {
    override def equal(value1: User, value2: User): Boolean = value1.name == value2.name && value1.email == value2.email
  }

  object Equal {
    def apply[T](a: T, b: T)(implicit equalizer: Equal[T]): Boolean = equalizer.equal(a, b)
  }

  println(Equal.apply(isaac, isaac))
  println(Equal(isaac, isaac))
  // => This is an AD-HOC Polymorphism : When calling Equal(..), the compiler will try to find the appropriate equalizer
  // depending on the type of the parameters (User in our case)

  implicit class TypeSafeEqual[T](value: T) {
    def ===(other: T)(implicit equalizer: Equal[T]): Boolean = equalizer.equal(value, other)
    def !==(other: T)(implicit equalizer: Equal[T]): Boolean = !equalizer.equal(value, other)
  }

  println(isaac === isaac)
  println(isaac === netero)
  /*
   => isaac.===(isaac)
   => new TypeSafeEqual[User](isaac).===(netero)
   => new TypeSafeEqual[User](isaac).===(netero)(NameEquality)
   */

  /*
  - This is type safe :
      println(isaac === 43) => won't compile, because parameters haven't the same type
   */
}
