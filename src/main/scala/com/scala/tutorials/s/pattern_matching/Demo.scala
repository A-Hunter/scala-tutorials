package com.scala.tutorials.s.pattern_matching

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * Pattern matching is the second most widely used feature of Scala, after function
  * values and closures. Scala provides great support for pattern matching, in processing
  * the messages.
  * A pattern match includes a sequence of alternatives, each starting with the keyword
  * case. Each alternative includes a pattern and one or more expressions, which will
  * be evaluated if the pattern matches. An arrow symbol => separates the pattern from
  * the expressions.
  */
case class Person(name: String, age: Int)

object Demo {
  def main(args: Array[String]) {

    println(matchTest(3))
    println(matchTest2("two"))
    println(matchTest2("test"))
    println(matchTest2(1))

    val alice = Person("Alice", 25)
    val bob = Person("Bob", 32)
    val charlie = Person("Charlie", 32)

    for (person <- List(alice, bob, charlie)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) => println(
          "Age: " + age + " year, name: " + name + " ?")
      }
    }
  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def matchTest2(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "many"
  }
}
