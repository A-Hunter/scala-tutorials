package com.scala.exercises.ex4_early_initializer

/**
  * Created by Ghazi Naceur on 07/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
case class FirstRectangle(h: Int, w: Int) extends Surface {

  override val height: Int = h
  override val width: Int = w
  // We need to override the area in order to have the product of height and width , otherwise
  //  we will have 'area = 0' because it is already initialized at 0 in the trait Surface
  override val area: Int = height * width
}
