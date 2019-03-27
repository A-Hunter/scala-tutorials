package com.scala.lang.org.r.abstract_types

/**
  * Created by Ghazi Naceur on 27/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

abstract class AnotherBuffer[+T] {
  val element: T
}
abstract class AnotherSeqBuffer[U, +T <: Seq[U]] extends AnotherBuffer[T] {
  def length = element.length
}

object AbstractTypeWithTypeParamaters extends App {

  def newIntSeqBuf(e1: Int, e2: Int): AnotherSeqBuffer[Int, Seq[Int]] =
    new AnotherSeqBuffer[Int, List[Int]] {
      val element = List(e1, e2)
    }

  val buf = newIntSeqBuf(7, 8)
  println("length = " + buf.length)
  println("content = " + buf.element)
}
