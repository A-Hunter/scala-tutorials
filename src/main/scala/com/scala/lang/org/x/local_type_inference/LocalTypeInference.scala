package com.scala.lang.org.x.local_type_inference

/**
  * Created by Ghazi Naceur on 28/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

case class MyPair[A, B](x: A, y: B)


object LocalTypeInference extends App {
  val x = 1 + 2 * 3 // the type of x is Int
  val y = x.toString() // the type of y is String
  def succ(x: Int) = x + 1 // method succ returns Int values

  //  For recursive methods, the compiler is not able to infer a result type. Here is a program
  //  which will fail the compiler for this reason:
  //  def fac(n: Int) = if (n == 0) 1 else n * fac(n - 1)
  //  Solution :
  def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)

  def id[T](x: T) = x

  val p = MyPair(1, "scala") // type: MyPair[Int, String]
  val q = id(1) // type: Int
  //  Is equivalent to :
  val pp: MyPair[Int, String] = MyPair[Int, String](1, "scala")
  val qq: Int = id[Int](1)

  //  var obj = null
  //  obj = new Object()
  //  This program does not compile because the type inferred for variable obj is Null. Since the only
  //  value of that type is null, it is impossible to make this variable refer to another value.
}
