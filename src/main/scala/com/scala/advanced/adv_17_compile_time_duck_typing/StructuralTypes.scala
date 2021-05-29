package com.scala.advanced.adv_17_compile_time_duck_typing

object StructuralTypes extends App {

  // Structural types
  type JavaCloseable = java.io.Closeable

  class HipsterCloseable {
    def close(): Unit = println("closing...")
    def closeSilently(): Unit = println("closing silently...")
  }

//  def closeQuietly(cloneable: JavaCloseable OR HipsterCloseable)

  type UnifiedCloseable = {
    def close(): Unit
  }
  // => This is a structural type

  def closeQuietly(unifiedCloseable: UnifiedCloseable): Unit = unifiedCloseable.close()

  closeQuietly(new JavaCloseable {
    override def close(): Unit = ???
  })
  closeQuietly(new HipsterCloseable)

  // Type refinements

  type AdvancedCloseable = JavaCloseable {
    def closeSilently(): Unit
  }

  class AdvancedJavaCloseable extends JavaCloseable {
    override def close(): Unit = println("Java closes")
    def closeSilently(): Unit = println("Java closes silently")
  }

  def closeAgain(advancedCloseable: AdvancedCloseable): Unit = advancedCloseable.closeSilently()

//  closeAgain(new AdvancedCloseable)
//  closeAgain(new HipsterCloseable) // won't compile because it doesn't originate from JavaCloseable

  // Using structural types as standalone types
  def alternativeClose(closeable: {def close(): Unit}): Unit = closeable.close() // "{def close(): Unit}" is its own type

  // type-checking => duck typing
  type SoundMaker = {
    def makeSound(): Unit
  }

  class Dog {
    def makeSound(): Unit = println("Bark")
  }

  class Car {
    def makeSound(): Unit = println("pip")
  }

  val dog: SoundMaker = new Dog
  val car: SoundMaker = new Car
  // => static duck typing

  // Caveat : based on reflection

  // Exercise 1 :
  trait CBL[+T] {
    def head: T
    def tail: CBL[T]
  }

  class Human {
    def head: Brain = new Brain
  }

  class Brain {
    override def toString: String = "Brains"
  }

  def f[T](somethingWithHead: {def head: T}): Unit = println(somethingWithHead.head)

  // f is compatible with CBL and Human
  case object CBNil extends CBL[Nothing] {
    override def head: Nothing = ???
    override def tail: CBL[Nothing] = ???
  }

  case class CBCons[T](override val head: T, override val tail: CBL[T]) extends CBL[T]

  f(CBCons(2, CBNil))
  f(new Human) // T = Brain

  // Exercise 2 :
  object HeadEqualizer {
    type Headable[T] = { def head: T }
    def ===[T](a: Headable[T], b: Headable[T]): Boolean = a.head == b.head
  }

  // HeadEqualizer.=== is compatible with CBL and Human

  val brainsList = CBCons(new Brain, CBNil)
  val stringsList = CBCons("Brains", CBNil)

  HeadEqualizer.===(brainsList, new Human)
  // problem :
  HeadEqualizer.===(new Human, stringsList) // This should be wrong : Not type safe
}
