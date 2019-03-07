package com.scala.exercises.ex4_early_initializer

/**
  * Created by Ghazi Naceur on 07/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
case class FirstRectangle(h: Int, w: Int) extends Surface {

  override val height: Int = h
  override val width: Int = w
  override val area: Int = height * width
}
