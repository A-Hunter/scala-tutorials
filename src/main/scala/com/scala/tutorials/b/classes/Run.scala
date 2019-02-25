package com.scala.tutorials.b.classes

/**
  * Created by Ghazi Naceur on 25/10/2018.
  */

/**
  * Implicit classes allow implicit conversations with class’s primary constructor when
  * the class is in scope. Implicit class is a class marked with ‘implicit’ keyword.
  * This feature is introduced in Scala 2.10.
  * Syntax − The following is the syntax for implicit classes. Here implicit class is
  * always in the object scope where all method definitions are allowed because implicit
  * class cannot be a top level class.
  *
  * Let us take an example of an implicit class named IntTimes with the method times().
  * It means the times () contain a loop transaction that will execute the given statement
  * in number of times that we give. Let us assume the given statement is
  * “4 times println (“Hello”)” means the println (“”Hello”) statement will execute 4 times.
  */
object Run {

  implicit class IntTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =

        if (current > 0) {
          println("current : "+current)
//          println("f : " +f)
          f
          loop(current - 1)
        }

      println("x : "+x)
      loop(x)
    }
  }

}
