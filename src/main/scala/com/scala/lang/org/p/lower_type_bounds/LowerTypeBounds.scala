package com.scala.lang.org.p.lower_type_bounds

/**
  * Created by Ghazi Naceur on 26/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

//lower type bounds declare a type to be a supertype of another type. The term B >: A expresses that the
// type parameter B or the abstract type B refer to a supertype of type A. In most cases, A will be the
// type parameter of the class and B will be the type parameter of a method.

/**
  trait Node[+B] {
    def prepend(elem: B): Unit
  }

  case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
    def prepend(elem: B) = ListNode[B](elem, this)

    def head: B = h

    def tail = t
  }

  case class Nil[+B]() extends Node[B] {
    def prepend(elem: B) = ListNode[B](elem, this)
  }

  However, this program does not compile because the parameter elem in prepend is of type B,
  which we declared covariant. This doesn’t work because functions are contravariant in their parameter
  types and covariant in their result types.

  To fix this, we need to flip the variance of the type of the parameter elem in prepend. We do this by
  introducing a new type parameter U that has B as a lower type bound.
*/

trait Node[+B] {
  def prepend[U >: B](elem: U)
}
case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
  def prepend[U >: B](elem: U) = ListNode[U](elem, this)
  def head: B = h
  def tail = t
}
case class Nil[+B]() extends Node[B] {
  def prepend[U >: B](elem: U) = ListNode[U](elem, this)
}


trait Mammal
case class AfricanSwallow() extends Mammal
case class EuropeanSwallow() extends Mammal

object LowerTypeBounds extends App {
  val africanSwallowList= ListNode[AfricanSwallow](AfricanSwallow(), Nil())
  val mammalList: Node[Mammal] = africanSwallowList
  mammalList.prepend(new EuropeanSwallow)
//  The Node[Mammal] can be assigned the africanSwallowList but then accept EuropeanSwallows.
}
