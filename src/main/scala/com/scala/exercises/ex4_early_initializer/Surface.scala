package com.scala.exercises.ex4_early_initializer

/**
  * Created by Ghazi Naceur on 07/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
trait Surface {
  val height: Int
  val width: Int
  val area: Int = height * width
}
