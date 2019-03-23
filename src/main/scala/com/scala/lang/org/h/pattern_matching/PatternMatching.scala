package com.scala.lang.org.h.pattern_matching

import scala.util.Random

/**
  * Created by Ghazi Naceur on 22/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

// Scala’s pattern matching statement is most useful for matching on algebraic types
// expressed via case classes. Scala also allows the definition of patterns
// independently of case classes, using unapply methods in extractor objects.
object PatternMatching extends App {

  val x: Int = Random.nextInt(10)
  x match {
    case 0 => println("zero")
    case 1 => println("one")
    case 2 => println("two")
    case _ => println("many")
  }

}
