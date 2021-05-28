package com.scala.advanced.adv_16_inner_types_and_path_dependent_types

object PathDependentTypes extends App {

  class Outer {
    class Inner
    object innerObject
    type InnerType

    def print(i: Inner) = println(i)
    def printGeneral(i: Outer#Inner) = println(i)
  }

  def method: Int = {
    class HelperClass
    type HelperType = String
    12
  }

  // per-instance
  val o = new Outer
  val inner = new o.Inner // o.Inner is a type

  val oo = new Outer
//  val otherInner: oo.Inner = new o.Inner // won't compile
  o.print(inner)
//  oo.print(inner) // not the same type

  // path-dependent types
  // Outer#Inner
  o.printGeneral(inner)
  oo.printGeneral(inner) // This is now valid, because we're using the Super type "Outer#Inner", which a super type for all inner types

  // Exercise :

  trait ItemLike {
    type Key
  }
  trait Item[K] extends ItemLike {
    override type Key = K
  }
  trait IntItem extends Item[Int]
  trait StringItem extends Item[String]

  def get[ItemType <: ItemLike](key: ItemType#Key): ItemType = ???

  get[IntItem](12) // OK
  get[StringItem]("some") // OK
//  get[IntItem]("12") // NOK
}
