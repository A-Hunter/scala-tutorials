package com.scala.tutorials.q.arrays.iterators

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * An iterator is not a collection, but rather a way to access the elements of a
  * collection one by one. The two basic operations on an iterator it are next and
  * hasNext. A call to it.next() will return the next element of the iterator and
  * advance the state of the iterator. You can find out whether there are more elements
  * to return using Iterator's it.hasNext method.
  * The most straightforward way to "step through" all the elements returned by an
  * iterator is to use a while loop.
  */
object Demo {
  def main(args: Array[String]) {

    val it = Iterator("a", "number", "of", "words")
    while (it.hasNext){
      println(it.next())
    }

    val ita = Iterator(20,40,2,50,69, 90)
    val itb = Iterator(20,40,2,50,69, 90)
    println("Maximum valued element " + ita.max)
    println("Minimum valued element " + itb.min)

    val itc = Iterator(20,40,2,50,69, 90)
    val itd = Iterator(20,40,2,50,69, 90)
    println("Value of itc.size : " + itc.size)
    println("Value of itd.length : " + itd.length)
  }
}
