package com.scala.advanced.adv_2_functional_set

import scala.annotation.tailrec

trait MySet[A] extends (A => Boolean) { // extends a Boolean, so there is an apply method to be implemented by the subtypes

  def apply(elem: A): Boolean = contains(elem)

  def contains(elem: A): Boolean
  def +(elem: A): MySet[A]
  def ++(anotherSet: MySet[A]): MySet[A]

  def map[B](f: A => B): MySet[B]
  def flatMap[B](f: A => MySet[B]): MySet[B]
  def filter(predicate: A => Boolean): MySet[A]
  def foreach(f: A => Unit): Unit
}

class EmptySet[A] extends MySet[A] {
  override def contains(elem: A): Boolean = false

  override def +(elem: A): MySet[A] = new NonEmptySet[A](elem, this)

  override def ++(anotherSet: MySet[A]): MySet[A] = anotherSet // because it's an (empty set ++ another set => another set)

  override def map[B](f: A => B): MySet[B] = new EmptySet[B]

  override def flatMap[B](f: A => MySet[B]): MySet[B] = new EmptySet[B]

  override def filter(predicate: A => Boolean): MySet[A] = this // there is nothing to filter. It is an empty list.

  override def foreach(f: A => Unit): Unit = ()

}

class NonEmptySet[A](head: A, tail: MySet[A]) extends MySet[A] {
  override def contains(elem: A): Boolean =
    elem == head || tail.contains(elem)

  override def +(elem: A): MySet[A] =
    if (this contains elem) this
    else new NonEmptySet[A](elem, this)

  /*
    * [1 2 3] ++ [4 5] =
    * [1 2] ++ [4 5] + 1 =
    * [1] ++ [4 5] + 1 + 2 =
    * [] ++ [4 5] + 1 + 2 + 3 =
    * [4 5] + 1 + 2 + 3 =
    * [4 5 1 2 3]
    */
  override def ++(anotherSet: MySet[A]): MySet[A] =
    tail ++ anotherSet + head // calling ++ recursively on tail and anotherSet, after that we add the head

  override def map[B](f: A => B): MySet[B] = (tail map f) + f(head)

  override def flatMap[B](f: A => MySet[B]): MySet[B] = (tail flatMap f) ++ f(head)

  override def filter(predicate: A => Boolean): MySet[A] = {
    val filteredTail = tail filter predicate
    if (predicate(head)) filteredTail + head
    else filteredTail
  }

  override def foreach(f: A => Unit): Unit = {
    f(head)
    tail foreach f
  }
}

object MySet {

  /*
   * val s = MySet(1,2,3) =
   * buildSet(seq(1,2,3), []) =
   * buildSet(seq(2,3), [] + 1) =
   * buildSet(seq(3), [1] + 2) =
   * buildSet(seq(), [1, 2] + 3) =
   * [1,2,3]
   */
  def apply[A](values: A*): MySet[A] = {
    @tailrec
    def buildSet(valSeq: Seq[A], acc: MySet[A]): MySet[A] =
      if (valSeq.isEmpty) acc
      else buildSet(valSeq.tail, acc + valSeq.head)

    buildSet(values.toSeq, new EmptySet[A])
  }
}

object MySetPlayground extends App {

  val s = MySet(1, 2, 3, 4, 5)
  s foreach println

  println("= Appending an element :")
  s + 6 foreach println

  println("= Concatenating 2 MySets :")
  s + 5 ++ MySet(7, 8 , -1) foreach println

  println("= Appending an existing element (elem 3) :")
  s + 5 ++ MySet(7, 8 , -1) + 3 foreach println

  println("= Exploring map() :")
  s + 5 ++ MySet(7, 8 , -1) + 3 map (_*10) foreach println

  println("= Exploring flatMap() :")
  s + 5 ++ MySet(7, 8 , -1) + 3 flatMap (x => MySet(x, 10 * x)) foreach println

  println("= Exploring filter() :")
  s + 5 ++ MySet(7, 8 , -1) + 3 flatMap (x => MySet(x, 10 * x)) filter (_ < 0) foreach println

}