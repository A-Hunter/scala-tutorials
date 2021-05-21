package com.scala.advanced.adv_6_lazy_evaluation

import scala.annotation.tailrec

abstract class MyStream[+A] {
  def isEmpty: Boolean
  def head: A
  def tail: MyStream[A]

  def #::[B >: A](element: B): MyStream[B] // prepend operator
  def ++[B >: A](anotherStream: => MyStream[B]): MyStream[B] // concatenate 2 streams

  def foreach(f: A => Unit): Unit
  def map[B](f: A => B): MyStream[B]
  def flatMap[B](f: A => MyStream[B]): MyStream[B]
  def filter(predicate: A => Boolean): MyStream[A]

  def take(n: Int): MyStream[A] // takes the first n elements of the stream and return a new MyStream
  def takeAsList(n: Int): List[A] = take(n).toList()

  @tailrec
  final def toList[B >: A](acc: List[B] = Nil): List[B] =
    if (isEmpty) acc.reverse
    else tail.toList(head :: acc)
}

object EmptyStream extends MyStream[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException
  def tail: MyStream[Nothing] = throw new NoSuchElementException

  def #::[B >: Nothing](element: B): MyStream[B] = new Cons[B](element, this)
  def ++[B >: Nothing](anotherStream: => MyStream[B]): MyStream[B] = anotherStream

  def foreach(f: Nothing => Unit): Unit = ()
  def map[B](f: Nothing => B): MyStream[B] = this
  def flatMap[B](f: Nothing => MyStream[B]): MyStream[B] = this
  def filter(predicate: Nothing => Boolean): MyStream[Nothing] = this

  def take(n: Int): MyStream[Nothing] = this
}

class Cons[+A](hd: A, tl: => MyStream[A]) extends MyStream[A] {
  // tail: => MyStream[A] ; The call by name (=>) is so important here to obtain lazy evaluated stream
  // This is very important in case we have an infinite steam
  def isEmpty: Boolean = false

  override val head: A = hd // We override this as a val, in order to use through all the body of this class
  override lazy val tail: MyStream[A] = tl // combining "a lazy val" and a "a call by name (=>)" is called a "call by need"

  def #::[B >: A](element: B): MyStream[B] = new Cons[B](element, this)
  def ++[B >: A](anotherStream: => MyStream[B]): MyStream[B] = new Cons[B](head, tail ++ anotherStream)

  def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }

  def map[B](f: A => B): MyStream[B] = new Cons[B](f(head), tail.map(f)) // map preserves the lazy evaluation
  def flatMap[B](f: A => MyStream[B]): MyStream[B] = f(head) ++ tail.flatMap(f) // flatMap preserves the lazy evaluation
  def filter(predicate: A => Boolean): MyStream[A] = // filter preserves the lazy evaluation
    if (predicate(head)) new Cons(head, tail.filter(predicate))
    else tail.filter(predicate)

  def take(n: Int): MyStream[A] = {
    if (n <= 0) EmptyStream
    else if (n == 1) new Cons(head, EmptyStream)
    else new Cons(head, tail.take(n - 1))
  }
}


object MyStream {
  def from[A](start: A)(generator: A => A): MyStream[A] =
    new Cons[A](start, MyStream.from(generator(start))(generator))
}

object StreamMain extends App {
  val naturals = MyStream.from(1)(_ + 1) // the tail is lazy evaluated, so the program won't crash (we're dealing with infinite values)
  println(naturals.head) // 1
  println(naturals.tail.head) // 2
  println(naturals.tail.tail.head) // 3

  val startFrom0 = 0 #:: naturals // translated by compiler to : naturals.#::(0)
  println(startFrom0.head) // 0
  println(startFrom0.tail.head) // 1
  println(startFrom0.tail.tail.head) // 2

  startFrom0.take(10000).foreach(println)

  println(startFrom0.map(_ * 2).take(10).toList())
  println(startFrom0.flatMap(x => new Cons(x, new Cons(x + 1, EmptyStream))).take(10).toList())

  println(startFrom0.filter(_ < 10).take(10).toList())

  def fibonacci(first: BigInt, second: BigInt): MyStream[BigInt] =
    new Cons[BigInt](first, fibonacci(second, first + second))

  println(fibonacci(1, 1).take(100).toList())

  // 2 3 5 6 7 8 9 10 11 ....
  // N eratosthenes means "x % N != 0"
  // 2 eratosthenes means "x % 2 != 0" => 3 5 7 9 11 ...
  // 2 3 eratosthenes means "x % 3 != 0" => 5 7 11 ...
  // 2 3 5 eratosthenes means "x % 5 != 0" => 7 11 ...
  // => prime numbers
  def eratosthenes(numbers: MyStream[Int]): MyStream[Int] =
    if (numbers.isEmpty) numbers
    else new Cons[Int](numbers.head, eratosthenes(numbers.tail.filter(_ % numbers.head != 0)))

  println(eratosthenes(MyStream.from(2)(_ + 1)).take(100).toList())
}