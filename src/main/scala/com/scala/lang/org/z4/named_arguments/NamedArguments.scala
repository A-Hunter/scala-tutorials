package com.scala.lang.org.z4.named_arguments

/**
  * Created by Ghazi Naceur on 30/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object NamedArguments extends App {
  def printName(first: String, last: String): Unit = {
    println(first + " " + last)
  }
  printName("John", "Smith")  // Prints "John Smith"
  printName(first = "John", last = "Smith")  // Prints "John Smith"
  printName(last = "Smith", first = "John")  // Prints "John Smith"

  def printName2(first: String, last: String): Unit = {
    println(first + " " + last)
  }
//  printName2(last = "Smith", "john")  // Does not compile
}
