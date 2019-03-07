package com.scala.exercises.ex4_early_initializer

/**
  * Created by Ghazi Naceur on 07/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
case class SecondRectangle(h: Int, w: Int)
  extends {
    val height = h
    val width = w
  } with Surface {
}
