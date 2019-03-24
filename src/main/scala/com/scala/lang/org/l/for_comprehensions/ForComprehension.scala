package com.scala.lang.org.l.for_comprehensions

/**
  * Created by Ghazi Naceur on 24/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

case class User(val name: String, val age: Int)

object ForComprehension extends App {

  val userBase = List(User("Travis", 28), User("Kelly", 33), User("Jennifer", 44), User("Dennis", 23))
  val twentySomethings = for (user <- userBase if (user.age >=20 && user.age < 30))
    yield user.name  // i.e. add this to a list
//  The for loop used with a yield statement actually creates a List.
//  Because we said yield user.name, it’s a List[String]. user <- userBase
  twentySomethings.foreach(name => println(name))  // prints Travis Dennis
}
