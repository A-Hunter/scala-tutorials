package com.scala.tutorials.q.arrays.options

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * Scala Option[ T ] is a container for zero or one element of a given type.
  * An Option[T] can be either Some[T] or None object, which represents a missing value.
  * For instance, the get method of Scala's Map produces Some(value) if a value
  * corresponding to a given key has been found, or None if the given key is not defined
  * in the Map.
  * Option type is used frequently in Scala programs and you can compare this with the
  * null value available in Java which indicate no value. For example, the get method
  * of java.util.HashMap returns either a value stored in the HashMap, or null if no value
  * was found.
  * Let's say we have a method that retrieves a record from the database based on a primary key.
  * def findPerson(key: Int): Option[Person]
  * The method will return Some[Person] if the record is found but None if the record is
  * not found. Let us follow the following program.
  */
object Demo {
  def main(args: Array[String]) {

    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    println("capitals.get(\"France\") : " + capitals.get("France"))
    println("capitals.get(\"India\") : " + capitals.get("India"))

    def show(x: Option[Any]) = x match {
      case Some(s) => s
      case None => "?"
    }

    List(Some("2"), Some(5), None).foreach(x => println(show(x)))

    val a: Option[Int] = Some(5)
    val b: Option[Int] = None
    println("a.getOrElse(0): " + a.getOrElse(0))
    println("b.getOrElse(10): " + b.getOrElse(10))

    println("a.isEmpty: " + a.isEmpty)
    println("b.isEmpty: " + b.isEmpty)
  }
}
