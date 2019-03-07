package com.scala.exercises.ex4_early_initializer

/**
  * Created by Ghazi Naceur on 07/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object Main {

  def main(args: Array[String]): Unit = {
    val first = FirstRectangle(10, 3)
    println("Area : " + first.area)

    val second = SecondRectangle(10, 3)
    println("Area : " + second.area)
  }
}
