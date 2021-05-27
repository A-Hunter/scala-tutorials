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

  object NameEquality extends Equal[User] {
    override def equal(value1: User, value2: User): Boolean = value1.name == value2.name
  }

  object FullEquality extends Equal[User] {
    override def equal(value1: User, value2: User): Boolean = value1.name == value2.name && value1.email == value2.email
  }
}
