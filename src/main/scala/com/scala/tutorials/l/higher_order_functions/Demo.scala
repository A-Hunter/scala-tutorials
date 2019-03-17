package com.scala.tutorials.l.higher_order_functions

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

/**
  * Scala allows the definition of higher-order functions. These are functions that
  * take other functions as parameters, or whose result is a function.
  * Try the following example program, apply() function takes another function f
  * and a value v and applies function f to v.
  */
object Demo {
  def main(args: Array[String]) {
    println(apply(layout, 10))
    println(apply(layout2, 50))
    println(doSomething(go, 1, 2, 3))
  }

  def apply(f: Int => String, v: Int): String = f(v)

  def layout[A](x: A): String = "[" + x.toString + "]"

  def layout2(v: Int): String = {
    v.toString
  }

  def doSomething(f: (Int, Int, Int) => Int, x: Int, y: Int, z: Int): Int = f(x, y, z)

  def go(x: Int, y: Int, z: Int): Int = {
    (x + y) * z
  }
}