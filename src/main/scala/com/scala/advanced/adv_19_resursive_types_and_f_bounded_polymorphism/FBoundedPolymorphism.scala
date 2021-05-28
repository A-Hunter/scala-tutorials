package com.scala.advanced.adv_19_resursive_types_and_f_bounded_polymorphism

object FBoundedPolymorphism extends App {

//  trait Animal {
//    def breed: List[Animal]
//  }
//
//  class Cat extends Animal {
//    override def breed: List[Animal] = ??? // We want List[Cat] instead of List[Animal]
//  }
//
//  class Dog extends Animal {
//    override def breed: List[Animal] = ??? // We want List[Dog] instead of List[Animal]
//  }

  // Solution 1 : Naive
//  trait Animal {
//    def breed: List[Animal]
//  }
//
//  class Cat extends Animal {
//    override def breed: List[Cat] = ???
//  }
//
//  class Dog extends Animal {
//    override def breed: List[Dog] = ???
//  }

  // Solution 2 : F-Bounded Polymorphism
//  trait Animal[A <: Animal[A]] { // recursive type : F-Bounded Polymorphism
//    def breed: List[Animal[A]]
//  }
//
//  class Cat extends Animal[Cat] {
//    override def breed: List[Animal[Cat]] = ???
//  }
//
//  class Dog extends Animal[Dog] {
//    override def breed: List[Animal[Dog]] = ???
//  }
//
//  trait Entity[E <: Entity[E]] // FBP : exists in ORM
//  class Person extends Comparable[Person] { // FBP as well
//    override def compareTo(t: Person): Int = ???
//  }
//
//  class Crocodile extends Animal[Dog] {
//    override def breed: List[Animal[Dog]] = ??? // problem : Enforce Animal[Crocodile] in this case
//  }

  // Solution 3 : FBP + self-types
//  trait Animal[A <: Animal[A]] { self: A =>
//    def breed: List[Animal[A]]
//  }
//
//  class Cat extends Animal[Cat] {
//    override def breed: List[Animal[Cat]] = ???
//  }
//
//  class Dog extends Animal[Dog] {
//    override def breed: List[Animal[Dog]] = ???
//  }

//  class Crocodile extends Animal[Dog] {
//    override def breed: List[Animal[Dog]] = ??? // The problem is solved here : won't compile as in the second solution
//  }

  // limitation :
//  trait Fish extends Animal[Fish]
//  class Shark extends Fish {
//    override def breed: List[Animal[Fish]] = List(new Cod) // problem
//  }
//  class Cod extends Fish {
//    override def breed: List[Animal[Fish]] = ???
//  }

  // Solution 4 : type classes

//  // Step 1
//  trait Animal
//  trait CanBreed[A] {
//    def breed(a: A): List[A]
//  }
//
//  // Step 2
//  class Dog extends Animal
//  object Dog {
//    implicit object DogsCanBreed extends CanBreed[Dog] {
//      override def breed(a: Dog): List[Dog] = ???
//    }
//  }
//
//  // Step 3
//  implicit class CanBreedOps[A](animal: A) {
//    def breed(implicit canBreed: CanBreed[A]): List[A] =
//      canBreed.breed(animal)
//  }
//
//  // Step 4
//  val dog = new Dog
//  dog.breed
//  /*
//  Compiler : new CanBreedOps[Dog](dog).breed(Dog.DogsCanBreed)
//  implicit value to pass to breed : Dog.DogsCanBreed
//   */
//
//  class Cat extends Animal
//  object Cat {
//    implicit object DogsCanBreed extends CanBreed[Dog] {
//      override def breed(a: Dog): List[Dog] = ???
//    }
//  }
//
//  val cat = new Cat
////  cat.breed // won't compile

  // Solution 5 : Pure type class
  trait Animal[A] {
    def breed(a: A): List[A]
  }

  class Dog
  object Dog {
    implicit object DogAnimal extends Animal[Dog] {
      override def breed(a: Dog): List[Dog] = ???
    }
  }

  implicit class AnimalOps[A](animal: A) {
    def breed(implicit animalTypeClassInstance: Animal[A]): List[A] =
      animalTypeClassInstance.breed(animal)
  }

  val dog = new Dog
  dog.breed

  class Cat
  object Cat {
    implicit object CatAnimal extends Animal[Dog] {
      override def breed(a: Dog): List[Dog] = ???
    }
  }

  val cat = new Cat
//  cat.breed // won't compile
}
