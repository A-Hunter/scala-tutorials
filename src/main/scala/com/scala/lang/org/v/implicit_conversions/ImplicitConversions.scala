package com.scala.lang.org.v.implicit_conversions
import scala.language.implicitConversions
/**
  * Created by Ghazi Naceur on 28/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
//  An implicit conversion from type S to type T is defined by an implicit value which has function
// type S => T, or by an implicit method convertible to a value of that type.
object ImplicitConversions extends App {
  implicit def list2ordered[A](x: List[A])
                              (implicit elem2ordered: A => Ordered[A]): Ordered[List[A]] =
    (that: List[A]) => ???
  implicit def int2ordered(x: Int): Ordered[Int] =
    (that: Int) => ???

  implicit def int2Integer(x: Int) =
    java.lang.Integer.valueOf(x)
}


