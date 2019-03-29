package com.scala.lang.org.y.operators

/**
  * Created by Ghazi Naceur on 29/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
//You can use any legal identifier as an operator. This includes a name like add or a symbol(s) like +.
case class Vec(x: Double, y: Double) {
  def +(that: Vec) = Vec(this.x + that.x, this.y + that.y)
}

case class MyBool(x: Boolean) {
  def and(that: MyBool): MyBool = if (x) that else this

  def or(that: MyBool): MyBool = if (x) this else that

  def negate: MyBool = MyBool(!x)
}

object Operators extends App {
  //  In Scala, operators are methods. Any method with a single parameter can be used as an infix operator.
  //  For example, + can be called with dot-notation:*
  val x = 10.+(1)
  //  However, it’s easier to read as an infix operator:
  val x2 = 10 + 1

  val vector1 = Vec(1.0, 1.0)
  val vector2 = Vec(2.0, 2.0)
  val vector3 = vector1 + vector2 // => This "+" is the function defined in the class Vec
  val vector4 = vector1.+(vector2) // => This "+" is the function defined in the class Vec
  println(vector3.x) // 3.0
  println(vector3.y) // 3.0
  println(vector4.y) // 3.0
  println(vector4.y) // 3.0

  def not(x: MyBool) = x.negate
  def xor(x: MyBool, y: MyBool) = (x or y) and not(x and y)

  /**
    When an expression uses multiple operators, the operators are evaluated based on the
    priority of the first character:
    (characters not shown below)
    * / %
    + -
    :
    = !
    < >
    &
    ^
    |
    (all letters)

    This applies to functions you define. For example, the following expression:

    a + b ^? c ?^ d less a ==> b | c
    Is equivalent to :

    ((a + b) ^? (c ?^ d)) less ((a ==> b) | c)
    ?^ has the highest precedence because it starts with the character ?. + has the second highest
    precedence, followed by ^?, ==>, |, and less.
    */
}
