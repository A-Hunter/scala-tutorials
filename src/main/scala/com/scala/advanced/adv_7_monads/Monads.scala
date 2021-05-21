package com.scala.advanced.adv_7_monads

object Monads extends App {

  // Custom Try monad
  trait Attempt[+A] {
    def flatMap[B](f: A => Attempt[B]): Attempt[B]
  }

  object Attempt {
    def apply[A](a: => A): Attempt[A] =
      try {
        Success(a)
      } catch {
        case ex: Throwable => Failure(ex)
      }
  }

  case class Success[+A](value: A) extends Attempt[A] {
    def flatMap[B](f: A => Attempt[B]): Attempt[B] =
      try {
        f(value)
      } catch {
        case ex: Throwable => Failure(ex)
      }
  }

  case class Failure(ex: Throwable) extends Attempt[Nothing] {
    def flatMap[B](f: Nothing => Attempt[B]): Attempt[B] = this
  }

  // Monad Laws :
  // 1- Left-identity :
  /*
  apply.flatMap(f) = f(x)
  Attempt(x).flatMap(f) = f(x) // Success case !
  Success(x).flatMap(f) = f(x)
   */

  // 2- Right-identity :
  /*
  attempt.flatMap(apply) = attempt
  Success(x).flatMap(x => Attempt(x)) = Attempt(x) = Success(x)
  Failure(e).flatMap(...) = Failure(e)
   */

  // 3- Associativity :
  /*
  attempt.flatMap(f).flatMap(g) == attempt.flatMap(x => f(x).flatMap(g))

  Failure(e).flatMap(f).flatMap(g) = Failure(e)
  Failure(e).flatMap(x => f(x).flatMap(g)) = Failure(e)

  Success(v).flatMap(f).flatMap(g) = f(v).flatMap(g) OR Failure(e)
  Success(v).flatMap(x => f(x).flatMap(g)) = f(v).flatMap(g) OR Failure(e)
   */

  // Monads = apply + flatMap
  // Monads = apply + map + flatten
  val attempt = Attempt {
    throw new RuntimeException("Some exception !")
  }

  println(attempt)
}
