package com.scala.lang.org.i.singleton_objects

/**
  * Created by Ghazi Naceur on 24/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

// The IntPair object is associated with a class with the same name = This a companion
// the singleton object is called the companion object of the class, and the class is
// called the companion class of the object.
class IntPair(val x: Int, val y: Int)

object IntPair {

  import math.Ordering

  implicit def ipord: Ordering[IntPair] =
    Ordering.by(ip => (ip.x, ip.y))
}

// It’s common to see typeclass instances as implicit values, such as ipord above,
// defined in the companion, when following the typeclass pattern. This is because
// the companion’s members are included in the default implicit search for related values.

// static is not a keyword in Scala. Instead, all members that would be static, including
// classes, should go in a singleton object.
class Companion {

  //  a common pattern is to import the companion object’s members in the class, like so:
  import IntPair._

  val foo = ipord

  //  This illustrates another feature: in the context of private, a class and its companion
  //  are friends. object X can access private members of class X, and vice versa. To make a
  //  member really private to one or the other, use private[this].

  //  A static method defined in the companion class, called a "static forwarder"

  //  If you move everything to a companion object and find that all you have left is a class
  //  you don’t want to be able to instantiate, simply delete the class. Static forwarders will
  //  still be created.
}
