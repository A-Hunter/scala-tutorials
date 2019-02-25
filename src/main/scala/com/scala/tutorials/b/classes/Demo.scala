package com.scala.tutorials.b.classes

import com.scala.tutorials.b.classes.Run._

/**
  * Created by Ghazi Naceur on 25/10/2018.
  */

object Demo {
  def main(args: Array[String]) {
    4 times println("hello")
    // param method_name simple_print

    /**
      * It can be translated to :
          val c = new IntTimes(4)
          c.times(println("hello"))
      That is, since there is an implicit class that takes an Int as its only argument,
      with a method times, doing 4.times implicitly instantiates the class with 4 as argument,
      and then invokes times on it.
      */
  }
}
