package com.scala.exercises.ex8_prime_factors

import scala.collection.mutable

/**
  * Created by Ghazi Naceur on 09/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object PrimeFactors {

  def findPrimeFactors(number: Int): mutable.Set[Int] = {
    var pf = mutable.Set[Int]()
    for (n <- 2 to number if n == 2 || number % n == 0 && n % 2 != 0) {
      pf += n
    }
    pf
  }

  def findPrimeFactors2(number: Int, list: List[Int] = List()): List[Int] = {
    for (n <- 2 to number if number % n == 0) {
      return findPrimeFactors2(number / n, list :+ n)
    }
    list
  }

  def findPrimeFactors3(number: Int, list: List[Int] = List()): Set[Int] = {
    for (n <- 2 to number if number % n == 0) {
      return findPrimeFactors3(number / n, list :+ n)
    }
    list.toSet
  }

  def main(args: Array[String]): Unit = {
    println(findPrimeFactors(44))
    println(findPrimeFactors2(44))
    println(findPrimeFactors3(44))
  }
}
