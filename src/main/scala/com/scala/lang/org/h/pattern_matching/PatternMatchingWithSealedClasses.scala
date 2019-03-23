package com.scala.lang.org.h.pattern_matching

/**
  * Created by Ghazi Naceur on 23/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

// This is useful for pattern matching because we don’t need a “catch all” case.
object PatternMatchingWithSealedClasses extends App {

  val furniture = new Chair

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }

  findPlaceToSit(furniture)

}
