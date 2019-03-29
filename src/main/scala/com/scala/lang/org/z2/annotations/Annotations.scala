package com.scala.lang.org.z2.annotations

/**
  * Created by Ghazi Naceur on 29/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

object DeprecationDemo extends App {
  @deprecated
  def hello = "hola"
  hello
}

/**
object NotTailRecursive extends App {
  import scala.annotation.tailrec
  def factorial(x: Int): Int = {
    @tailrec
    def factorialHelper(x: Int): Int = {
      if (x == 1) 1 else x * factorialHelper(x - 1)
    }
    factorialHelper(x)
  }
}
*/
//Certain annotations will actually cause compilation to fail if a condition(s) is not met.
// For example, the annotation @tailrec ensures that a method is tail-recursive.
// Tail-recursion can keep memory requirements constant.
object TailRecursive extends App {
  import scala.annotation.tailrec
  def factorial(x: Int): Int = {
    @tailrec
    def factorialHelper(x: Int, accumulator: Int): Int = {
      if (x == 1) accumulator else factorialHelper(x - 1, accumulator * x)
    }
    factorialHelper(x, 1)
  }
}

object Annotations extends App {

}
