package com.scala.advanced.adv_7_monads

class LazyMonad[+A](value: => A) {
  private lazy val internalValue = value
  def use: A = internalValue // a method for test purposes
  def flatMap[B](f: (=> A) => LazyMonad[B]): LazyMonad[B] = f(internalValue)
  // To delay the evaluation of the parameter value, we need to use a call by name as well :
  // (f: A => LazyMonad[B]) => (f: (=> A) => LazyMonad[B])
}
object LazyMonad {
  def apply[A](value: => A): LazyMonad[A] = new LazyMonad[A](value)
}

object LazyMonadMain extends App {
  val lazyInstance = LazyMonad {
    println("something and else")
    42
  }

//  println(lazyInstance.use)

  val flatMappedInstance = lazyInstance.flatMap(x => LazyMonad {
    10 * x
  })

  val flatMappedInstance2 = lazyInstance.flatMap(x => LazyMonad {
    10 * x
  })

  flatMappedInstance.use
  flatMappedInstance2.use
  // => Only the first statement will be evaluated because we use a lazy internalValue "private lazy val internalValue = value"

  /*
  - left-identity :
    apply.flatMap(f) = f(v)
    Lazy(v).flatMap(f) = f(v)

  - right-identity :
    l.flatMap(apply) = l
    Lazy(v).flatMap(x => Lazy(x)) = Lazy(v)

  - associativity :
    l.flatMap(f).flatMap(g) = l.flatMap(x => f(x).flatMap(g))

    Lazy(v).flatMap(f).flatMap(g) = f(v).flatMap(g)
    Lazy(v).flatMap(x => f(x).flatMap(g)) = f(v).flatMap(g)
   */

  // map + flatten :
  /*
  Monad[T] {
    def flatMap[B](f: T => Monad[B]): Monad[B] = ... (implemented)

    def map[B](f: T => B): Monad[B] = flatMap(x => apply(f(x))) // Monad[B]
    List(1,2,3).map(_ * 2) = List(1,2,3).flatMap(x => List(x * 2))

    def flatten(m: Monad[Monad[T]]): Monad[T] = m.flatMap((x: Monad[T]) => x)
    List(List(1,2), List(3,4)).flatten = List(List(1,2), List(3,4)).flatMap(x => x) = List(1,2,3,4)
  }
   */
}