package com.scala.lang.org.b.traits

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Ghazi Naceur on 19/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
trait Pet {
  val name: String
}

// "name" is overridden, this time, in the constructor, not in the body of the class
class Dog(val name: String) extends Pet
class Cat(val name: String) extends Pet

object Pet{
  def main(args: Array[String]): Unit = {

    val dog = new Dog("Rex")
    val cat = new Dog("Tom")
    val pets = ArrayBuffer.empty[Pet]

    pets.append(dog)
    pets.append(cat)

    pets.foreach(pet => println(pet.name))
  }
}