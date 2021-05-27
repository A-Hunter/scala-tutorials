package com.scala.advanced.adv_12_implicits

object TypeClasses extends App {

  trait HTMLWritable {
    def toHTML: String
  }

  case class User(name: String, age: Int, email: String) extends HTMLWritable {
    override def toHTML: String = s"<div>$name ($age yo) <a href=$email/> </div>"
  }

  User("Isaac", 125, "issac.netero@hunter.com").toHTML
  /* Drawbacks :
  1 - toHTML works only for the type User
  2 - It's 1 implementation
   */

  trait HTMLSerializer[T] {
    def serialize(value: T): String
  }

  object UserSerializer extends HTMLSerializer[User] {
    override def serialize(user: User): String = s"<div>${user.name} (${user.age} yo) <a href=${user.email}/> </div>"
  }

  val isaac = User("Isaac", 125, "isaac.netero@hunter.com")
  println(UserSerializer.serialize(isaac))

  // 1- We can define serializers for other types
  import java.util.Date
  object DateSerializer extends HTMLSerializer[Date] {
    override def serialize(date: Date): String = s"<div>date=${date.toString}</div"
  }

  // 2- We can define multiple implementations for the same type
  object PartialUserSerializer extends HTMLSerializer[User] {
    override def serialize(user: User): String =  s"<div>${user.name}</div>"
  }

  // HTMLSerializer is Type class
  // T is a type parameter
  // UserSerializer, PartialUserSerializer and DateSerializer are type class instances


  // Type class example
  trait Equal[T] {
    def equal(value1: T, value2: T): Boolean
  }

  implicit object NameEquality extends Equal[User] {
    override def equal(value1: User, value2: User): Boolean = value1.name == value2.name
  }

  object FullEquality extends Equal[User] {
    override def equal(value1: User, value2: User): Boolean = value1.name == value2.name && value1.email == value2.email
  }

  object HTMLSerializer {
    def serialize[T](value: T)(implicit serializer: HTMLSerializer[T]): String =
      serializer.serialize(value)

    // surface out the serializer with an apply method => Access to the entire type class interface
    def apply[T](implicit serializer: HTMLSerializer[T]) = serializer
  }

  implicit object IntSerializer extends HTMLSerializer[Int] {
    override def serialize(value: Int): String = s"<div>Integer: $value</div>"
  }

  println(HTMLSerializer.serialize(User("Isaac", 125, "isaac.netero@hunter.com"))(UserSerializer))
  println(HTMLSerializer.serialize(56)) // IntSerializer is implicit not like UserSerializer, so no need to provide it as a parameter
                                              // The compiler will figure out that we need to use the IntSerializer implicitly
  println(HTMLSerializer[Int].serialize(56)) // We're apply to specify the Type "Int" here, because we're using "apply" method
  // inside the companion object, which surfaced out the serializer (the implicit instance) => Access to the entire type class interface

  trait MyTypeClassTemplate[T] {
    def action(value: T): String
  }

  object MyTypeClassTemplate {
    def apply[T](implicit instance: MyTypeClassTemplate[T]) = instance
  }

  object Equal {
    def apply[T](a: T, b: T)(implicit equalizer: Equal[T]): Boolean = equalizer.equal(a, b)
  }

  private val netero: User = User("Netero", 125, "isaac.netero@hunter.com")

  println(Equal.apply(netero, netero))
  println(Equal(netero, netero))
  // => This is an AD-HOC Polymorphism : When calling Equal(..), the compiler will try to find the appropriate equalizer
  // depending on the type of the parameters (User in our case)

}
