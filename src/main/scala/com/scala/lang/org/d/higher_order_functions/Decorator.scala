package com.scala.lang.org.d.higher_order_functions

/**
  * Created by Ghazi Naceur on 20/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
class Decorator(left: String, right: String) {
  def show[A](message: A): String = {
    left + message + right
  }
}

object Decorator extends App {
  def applyString(f: String => String, v: String): String = f(v)
  def applyInt(f: Int => String, v: Int): String = f(v)
  val decorator = new Decorator("[", "]")
  println(applyString(decorator.show, "message"))
  println(applyInt(decorator.show, 7))
}
