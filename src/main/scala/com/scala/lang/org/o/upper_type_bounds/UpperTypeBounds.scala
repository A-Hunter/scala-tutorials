package com.scala.lang.org.o.upper_type_bounds

/**
  * Created by Ghazi Naceur on 25/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

abstract class Animal {
  def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  override def name: String = "Cat"
}

class Dog extends Pet {
  override def name: String = "Dog"
}

class Lion extends Animal {
  override def name: String = "Lion"
}

//An upper type bound T <: A declares that type variable T refers to a subtype of type A
class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}

object UpperTypeBounds extends App {
  val dogContainer = new PetContainer[Dog](new Dog)
  val catContainer = new PetContainer[Cat](new Cat)
  val lionContainer = new PetContainer[Lion](new Lion)
  //                         ^this would not compile

  //  The class PetContainer take a type parameter P which must be a subtype of Pet. Dog and Cat are subtypes
  //  of Pet so we can create a new PetContainer[Dog] and PetContainer[Cat]. However, if we tried to create
  //  a PetContainer[Lion], we would get the following Error:
  //  type arguments [Lion] do not conform to class PetContainer's type parameter bounds [P <: Pet]
  //  This is because Lion is not a subtype of Pet.
}
