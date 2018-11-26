package com.scala.exercises.ex1

import scala.util.control.Breaks

/**
  * Created by Ghazi Naceur on 25/11/2018.
  */
class Ex1 {

  def evenNumber(number: Int): Boolean ={
    number % 2 == 0
  }

  def exitsEvenNumber(list: List[Int]): Boolean ={

      for (a <- list) {
        if (a % 2 ==0) {
          return true
        }
      }
    false
  }

  def twistedSum(list: List[Integer]): Int ={
    var sum: Integer = 0

    list.foreach(x => {
      if (x == 7) {
        sum += 14
      } else {
        sum += x
      }
    })
    sum
  }

  def canBeEquallySplit(list: List[Int]): Boolean ={
    var canBeSplit: Boolean = false
    var half: Int = 0
    val loop = new Breaks

    loop.breakable {
      for (a <- list) {
        half += a
        if (half == list.sum / 2) {
          canBeSplit = true
          loop.break
        }
      }
    }
    canBeSplit
  }

  def canBeEquallySplitV2 (list: List[Int]): Boolean ={

    var firstHalf = 0
    var secondHalf = 0
    secondHalf = list.sum

    for (i <- list.indices){
      firstHalf += list(i)
      secondHalf -= list(i)

      if (firstHalf == secondHalf){
        return true
      }
    }
    false
  }

  def palindrome(string: String): Boolean ={
    string.reverse.equals(string)
  }
}
