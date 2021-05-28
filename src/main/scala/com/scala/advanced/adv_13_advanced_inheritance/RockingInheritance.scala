package com.scala.advanced.adv_13_advanced_inheritance

object RockingInheritance extends App {

  // convenience
  trait Writer[T] {
    def write(value: T): Unit
  }

  trait Closeable {
    def close(status: Int): Unit
  }

  trait GenericStream[T] {
    def foreach(f: T => Unit): Unit
  }

  def processStream[T](stream: GenericStream[T] with Writer[T] with Closeable): Unit = {
    stream.foreach(println)
    stream.close(0)
  }
  // Whenever we don't know who exactly mixes in our specific traits, we can use them all in a specific type as a parameter
  // to a method. In our case, the specific type is "GenericStream[T] with Writer[T] with Closeable"

  // diamond problem
  trait Animal {def name: String}
  trait Lion extends Animal {
    override def name: String = "Lion"
  }
  trait Tiger extends Animal {
    override def name: String = "Tiger"
  }
  class Mutant extends Lion with Tiger

  val m = new Mutant
  println(m.name)
  /*
  Equivalent to :
  Mutant
    extends Animal with {override def name: String = "Lion"}
    with {override def name: String = "Tiger"}
   => double override, so "Tiger" will be taken, because it overrides "Lion"
   => Last override gets picked
   */

  // the super problem + type linearization
  trait Cold {
    def print = println("cold")
  }
  trait Green extends Cold {
    override def print: Unit = {
      println("green")
      super.print
    }
  }
  trait Blue extends Cold {
    override def print: Unit = {
      println("blue")
      super.print
    }
  }
  class Red {
    def print = println("red")
  }
  class White extends Red with Green with Blue {
    override def print: Unit = {
      println("white")
      super.print
    }
  }

  val color = new White
  println(color.print)

  /*
  Cold -----> Green----\
        |----> Blue----|--> White
               Red ----/

   The compiler interprets this :
      White = Red with Green with Blue with <White> (body of White)
            = AnyRef with <Red>
                     with (AnyRef with <Cold> with <Green>)
                     with (AnyRef with <Cold> with <Blue>)
                     with <White>
            (Compiler will omit duplicate Classes)
            = AnyRef with <Red> with <Cold> with <Green> with <Blue> with <White>
            (This is called type linearization for White)
            (each call of "super", the compiler will look for the previous Class of White inside the linearization; In this
            case it's Blue, after that it's Green, the following will be Cold)
   */
}
