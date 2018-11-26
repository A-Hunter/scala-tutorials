package com.scala.exercises.ex1

/**
  * Created by Ghazi Naceur on 25/11/2018.
  */
object Ex1Main extends App {

  private val ex = new Ex1

  println("Even number :")
  println(ex.evenNumber(2))
  println(ex.evenNumber(3))

  println("Even number in list :")
  println(ex.exitsEvenNumber(List(1, 2, 3)))
  println(ex.exitsEvenNumber(List(1, 3, 3)))

  println("Twisted sum :")
  println(ex.twistedSum(List(1, 7, 3)))
  println(ex.twistedSum(List(1, 7, 7)))
  println(ex.twistedSum(List(1, 2, 3)))

  println("Equally split list :")
  println(ex.canBeEquallySplit(List(1, 2, 3)))
  println(ex.canBeEquallySplit(List(1, 3, 3, 4 ,2, 13)))
  println(ex.canBeEquallySplit(List(1, 2, 3, 4)))

  println("Equally split list V2 :")
  println(ex.canBeEquallySplitV2(List(1, 2, 3)))
  println(ex.canBeEquallySplitV2(List(1, 3, 3, 4 ,2, 13)))
  println(ex.canBeEquallySplitV2(List(1, 2, 3, 4)))

  println("Palindrome :")
  println(ex.palindrome("text"))
  println(ex.palindrome("texet"))
}
