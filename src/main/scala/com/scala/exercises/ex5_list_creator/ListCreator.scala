package com.scala.exercises.ex5_list_creator

/**
  * Created by Ghazi Naceur on 08/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object ListCreator extends App {

  def listToTen(i: Int): List[Int] = {
    if (i <= 10) {
      i :: listToTen(i + 1)
    } else {
      Nil
    }
  }

  val listOneToTen = listToTen(1)
  println(listOneToTen)
}
