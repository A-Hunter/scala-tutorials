package com.scala.lang.org.n.variances

/**
  * Created by Ghazi Naceur on 25/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
// Making A covariant implies that for two types A and B where A is a subtype of B, then List[A]
// is a subtype of List[B]. This allows us to make very useful and intuitive subtyping
// relationships using generics
abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal

case class Dog(name: String) extends Animal

object Covariance extends App {
  //  Both Cat and Dog are subtypes of Animal. The Scala standard library has a generic immutable
  //  sealed abstract class List[+A] class, where the type parameter A is covariant.
  //  This means that a List[Cat] is a List[Animal] and a List[Dog] is also a List[Animal].

  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)
  printAnimalNames(dogs)
}
