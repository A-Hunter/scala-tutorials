package com.scala.advanced.adv_14_variance

object Variance extends App {

  trait Animal
  class Dog extends Animal
  class Cat extends Animal
  class Crocodile extends Animal

  // what is variance ?
  // inheritance - type substitution of generics

  class Cage[T]
  // covariance
  class CCage[+T]
  val ccage: CCage[Animal] = new CCage[Cat]

  // invariance
  class ICage[T]
//  val icage: ICage[Animal] = new ICage[Cat] // This won't compile. Similar to : val x: Int = "something"

  // contravariance
  class XCage[-T]
  val xcage: XCage[Cat] = new XCage[Animal] // this makes sense

  class InvarianceCage[T](animal: T) // invariant

  // covariant position
  class CovariantCage[+T](val animal: T) // covariant position : the argument animal

//  class ContravariantCage[-T](val animal: T) // won't compile
  /*
  Equivalent to :
  val catCage: XCage[Cat] = new XCage[Animal](new Crocodile) // wrong
   */

//  class CovariantVariableCage[+T](var animal: T) // won't compile because types of vars are in a contravariance position
  /*
  Equivalent to :
  val ccage: CCage[Animal] = new CCage[Cat](new Cat)
  ccage.animal = new Crocodile // wrong
   */

//  class ContravariantVariableCage[-T](var animal: T) // won't compile : animal is in covariant position
  /*
  Equivalent to :
  val catCage: XCage[Cat] = new XCage[Animal](new Crocodile) // wrong
 */

  class InvariantVariableCage[T](var animal: T) // correct

//  trait AnotherCovariantCage[+T] {
//    def addAnimal(animal: T) // contravariant position // won't compile
//  }
  /*
  val ccage: CCage[Animal] = new CCage[Dog]
  ccage.add(new Cat)
   */

  class AnotherContravariantCage[-T] {
    def addAnimal(animal: T) = true
  }
  val acc: AnotherContravariantCage[Cat] = new AnotherContravariantCage[Animal]
//  acc.addAnimal(new Dog) // won't compile
  acc.addAnimal(new Cat)
  class Kitty extends Cat
  acc.addAnimal(new Kitty)

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = new MyList[B]// widening the type
  }

  val emptyList = new MyList[Kitty]
  val animals = emptyList.add(new Kitty)
  val animal = emptyList.add(new Kitty)
  val moreAnimals = animals.add(new Cat) // Cat is a super type of Kitty : works through the type widening
  val evenMoreAnimals = moreAnimals.add(new Dog) // will work as well thanks to type widening, because Dog is Animal

  // Method arguments are in contravariant position

  // return types
//  class PetShop[-T] {
//    def get(isItaPuppy: Boolean): T // won't compile, because return type is in covariant position
//  }
  /*
  Equivalent to :
    val catShop = new PetShop[Animal] {
      def get(isItaPuppy: Boolean): Animal = new Cat
    }

    val dogShop: PetShop[Dog] = catShop
    dogShop.get(true) // wrong

    => To fix this, we need to return a subtype of T
   */
  class PetShop[-T] {
    def get[S <: T](isItaPuppy: Boolean, defaultAnimal: S): S = defaultAnimal
  }

  val shop: PetShop[Dog] = new PetShop[Animal]
//  val evilCat = shop.get(true, new Cat) // won't compile
  class TerraNova extends Dog
  val bigFurry = shop.get(true, new TerraNova) // works

  /*
  Summary :
  - method arguments are in contravariant position
  - return types are in covariant position
   */
}
