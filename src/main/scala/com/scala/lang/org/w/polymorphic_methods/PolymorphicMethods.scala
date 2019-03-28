package com.scala.lang.org.w.polymorphic_methods

/**
  * Created by Ghazi Naceur on 28/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object PolymorphicMethods extends App {
//  Methods in Scala can be parameterized by type as well as value.
  def listOfDuplicates[A](x: A, length: Int): List[A] = {
    if (length < 1)
      Nil
    else
      x :: listOfDuplicates(x, length - 1)
  }
  println(listOfDuplicates[Int](3, 4))  // List(3, 3, 3, 3)
  println(listOfDuplicates("La", 8)) // List(La, La, La, La, La, La, La, La)
  //  When we call listOfDuplicates with [Int] as the type parameter, the first argument must be an
  //  int and the return type will be List[Int]. However, you don’t always need to explicitly provide
  //  the the type parameter because the compiler can often figure it out based on the type of value
  //  argument ("La" is a String).
}
