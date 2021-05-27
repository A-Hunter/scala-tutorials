package com.scala.advanced.adv_12_implicits

object LibraryEnrichment extends App {

  // Decorating existing classes with additional methods and classes

  implicit class RichInt(value: Int) {
    def isEven: Boolean = value % 2 == 0
    def sqrt: Double = Math.sqrt(value)
    def times(function: () => Unit): Unit = {
      def timesAux(n: Int): Unit = {
        if (n <= 0) ()
        else {
          function()
          timesAux(n - 1)
        }
      }
      timesAux(value)
    }

    def *[T](list: List[T]): List[T] = {
      def concatenate(n: Int): List[T] =
        if (n <= 0) List()
        else concatenate(n - 1) ++ list
      concatenate(value)
    }
  }

//  We can write :
  println(new RichInt(12).sqrt)
//  or :
  println(12.sqrt)

  // The compiler does not do multiple implicit searches.
  // We cannot enrich an implicit class with another implicit class.

  implicit class RichString(value: String) {
    def asInt: Int = Integer.valueOf(value)
    def encrypt(cypherDistance: Int): String = value.map(c => (c + cypherDistance).asInstanceOf[Char])
  }

  println("3".asInt)
  println("something".encrypt(2))

  3.times(() => println("printing..."))
  println(4 * List(12,5,6))

  implicit def stringToInt(string: String): Int = Integer.valueOf(string)

  println("6" / 2) // "6" will be converted to Int, without calling "stringToInt" method
  // This will be rewritten to : stringToInt("6") / 2

  // Equivalent to an implicit class : implicit class RichAltInt(value: Int)
  class RichAltInt(value: Int)
  implicit def enrich(value: Int): RichAltInt = new RichAltInt(value)

  // implicit def are dangerous : If there is a bug in the method, it will be difficult to trace it back / difficult to debug

/*
  Best practises :
    - Keep type enrichment to implicit classes and type classes
    - Avoid implicit defs as much as possible
    - package implicits clearly, bring into scope only what you need
    - If you need conversions, make them specific
 */

}
