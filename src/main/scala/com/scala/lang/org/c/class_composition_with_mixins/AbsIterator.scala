package com.scala.lang.org.c.class_composition_with_mixins

/**
  * Created by Ghazi Naceur on 20/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

/**
  *
trait AbsIterator[A] {
  def hasNext: Boolean
  def next(): A
}
  It is the same as :
  */
trait AbsIterator {
  type A
  def hasNext: Boolean
  def next: A
}

class StringIterator(text: String) extends AbsIterator {
  override type A = Char
  var current: Int = 0
  override def hasNext: Boolean = current < text.length

  override def next: Char = {
    // wihtout a hasNext condition
    val iterator = text charAt current
    current += 1
    iterator
  }
}

trait RichIterator extends AbsIterator {
  // implementing the hasNext condition
  def foreach(f: A => Unit): Unit = while (hasNext) f(next)
}

object AbsIterator {
  def main(args: Array[String]): Unit = {

    val message = "this a text"

    class RichStringIter extends StringIterator(message) with RichIterator

    val iter = new RichStringIter
    iter foreach println
//     It is the same as :
//    iter.foreach(x => println(x))
  }
}