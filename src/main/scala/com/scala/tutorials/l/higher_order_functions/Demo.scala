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
    println( apply( layout, 10) )
  }

  def apply(f: Int => String, v: Int) = f(v)

  def layout[A](x: A) = "[" + x.toString() + "]"
}