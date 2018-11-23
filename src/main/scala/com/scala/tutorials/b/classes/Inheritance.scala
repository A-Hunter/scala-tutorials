package com.scala.tutorials.b.classes

/**
  * Created by Ghazi Naceur on 23/11/2018.
  */

class A{
  def greet = "Hello ! It's A"
}

class B extends A

class C extends B {
  override def greet: String = super.greet
}

class D extends C {
  override def greet: String = "Hello ! It is D"
}

object Inheritance {
  def main (args: Array[String] ): Unit = {
    val a = new A
    println(a.greet)

    val b = new B
    println(b.greet)

    val c = new C
    println(c.greet)

    val d = new D
    println(d.greet)
  }
}