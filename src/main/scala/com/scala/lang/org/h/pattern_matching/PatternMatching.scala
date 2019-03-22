package com.scala.lang.org.h.pattern_matching

import scala.util.Random

/**
  * Created by Ghazi Naceur on 22/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object PatternMatching extends App {

  val x: Int = Random.nextInt(10)
  x match {
    case 0 => println("zero")
    case 1 => println("one")
    case 2 => println("two")
    case _ => println("many")
  }

}
