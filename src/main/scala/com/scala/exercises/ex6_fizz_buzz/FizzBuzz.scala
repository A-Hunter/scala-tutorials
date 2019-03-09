package com.scala.exercises.ex6_fizz_buzz

/**
  * Created by Ghazi Naceur on 09/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object FizzBuzz {
  def fizz(value: Int): String = {
    if (value % 3 == 0){
      "fizz"
    } else {
      value.toString
    }
  }

  def buzz(value: Int): String = {
    if (value % 5 == 0){
      "buzz"
    } else {
      value.toString
    }
  }

  def fizzBuzz(value: Int): String = {
    if (fizz(value) == "fizz" && buzz(value) == "buzz"){
      "fizzbuzz"
    } else {
      value.toString
    }
  }

  // This is the best solution
  def getResult(number: Int): String = (number % 3, number % 5) match {
    case (0 , 0) => "fizzbuzz"
    case (0 , _) => "fizz"
    case (_ , 0) => "buzz"
    case  _      => number.toString
  }

  def main(args: Array[String]): Unit = {
    println(fizz(3))
    println(buzz(3))
    println(fizzBuzz(3))

    println(fizz(5))
    println(buzz(5))
    println(fizzBuzz(5))

    println(fizz(15))
    println(buzz(15))
    println(fizzBuzz(15))

    println(getResult(3))
    println(getResult(5))
    println(getResult(15))
    println(getResult(23))
  }
}
