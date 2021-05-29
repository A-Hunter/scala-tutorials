package com.scala.advanced.adv_21_reflection

object Reflection extends App {

  // reflection + macros + quasiquotes => metaprogramming

   case class Person(name: String) {
     def sayMyName(): Unit = println(s"My name is $name")
   }

  // 0- import
  import scala.reflect.runtime.{universe => ru}

  // 1- instantiate a mirror
  val m = ru.runtimeMirror(getClass.getClassLoader)

  // 2- create a class object by name (like a description of a class)
  val clazz = m.staticClass("com.scala.advanced.adv_21_reflection.Reflection.Person")

  // 3- create a reflected mirror (can do things)
  val cm = m.reflectClass(clazz)

  // 4- get the constructor
  val constructor = clazz.primaryConstructor.asMethod

  // 5- reflect the constructor
  val constructorMirror = cm.reflectConstructor(constructor)

  // 6- invoke the constructor
  val instance = constructorMirror.apply("Netero")

  println(instance)


  val p = Person("Itachi")
  val methodName = "sayMyName"

  // 1- mirror
  // 2- reflect the instance
  val reflected = m.reflect(p)
  // 3- method symbol
  val methodSymbol = ru.typeOf[Person].decl(ru.TermName(methodName)).asMethod
  // 4- reflect the method - can do things
  val method = reflected.reflectMethod(methodSymbol)
  // 5- invoke method
  method.apply()


  // Type erasure
  // Generic types are erased at compile time
  // Pb1: You cannot differentiate between generic types at runtime

  val numbers = List(1,2,3)
  numbers match {
    case listOfStrings: List[String] => println("list of strings") // This will be printed
    case listOfNumbers: List[Int] => println("list of numbers")
  }

  // Pb2 : limitations on overloads
//  def processList(list: List[Int]): Int = 12
//  def processList(list: List[String]): Int = 23

  // Solution:
  // Types Tags

  // 0- import
  import ru._

  // 1- create type tag (manually)
  val ttag = typeTag[Person]
  println(ttag.tpe)

  class MyMap[K,V]
  // 2- pass type tags as implicit parameters
  def getTypeArguments[T](value: T)(implicit typeTag: TypeTag[T]) = typeTag.tpe match {
    case TypeRef(_, _, typeArguments) => typeArguments
    case _ => List()
  }

  val myMap = new MyMap[Int, String]
  val typesArgs = getTypeArguments(myMap)
  println(typesArgs)

  def isSubType[A, B](implicit ttagA: TypeTag[A], ttagB: TypeTag[B]): Boolean = {
    ttagA.tpe <:< ttagB.tpe
  }

  class Animal
  class Dog extends Animal
  println(isSubType[Dog, Animal])

  val anotherMethodSymbol = typeTag[Person].tpe.decl(ru.TermName(methodName)).asMethod
  val sameMethod = reflected.reflectMethod(anotherMethodSymbol)
  sameMethod.apply()
}
