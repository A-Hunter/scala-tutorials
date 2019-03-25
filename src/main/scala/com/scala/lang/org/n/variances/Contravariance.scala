package com.scala.lang.org.n.variances

/**
  * Created by Ghazi Naceur on 25/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit =
    println("The cat's name is: " + cat.name)
}

object Contravariance extends App {
  //  opposite to what we get with covariance. That is, for some class Writer[-A], making A contravariant
  //  implies that for two types A and B where A is a subtype of B, Writer[B] is a subtype of Writer[A].
  val myCat: Cat = Cat("Boots")

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  //  The inverse relationship does not apply, because a Printer[Cat] does not know how to print any Animal to
  //  the console
  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter
  printMyCat(catPrinter)
  printMyCat(animalPrinter)
}
