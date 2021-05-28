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

  //////////////////////////////////////////////////////////////////////////////////////////////////
//  Steps to create an implicit
  // Step 1 : Type class
  trait MyTypeClassTemplate[T] {
    def action(value: T): String
  }

  // Step 2 : Type class instances (often implicit)
  implicit object MyTypeClassInstance extends MyTypeClassTemplate[Int] {
    override def action(value: Int): String = String.valueOf(value)
  }

  // Step 3 : Invoking type class instances
  object MyTypeClassTemplate {
    def apply[T](implicit instance: MyTypeClassTemplate[T]) = instance
  }

  // Step 4 : Enriching types with types classes
  implicit class HTMLEnrichment[T](value: T) {
    def toHTML(implicit serializer: HTMLSerializer[T]): String = serializer.serialize(value)
  }

  println(new HTMLEnrichment[User](isaac).toHTML(UserSerializer))
  // Equivalent to :
  println(isaac.toHTML)
  println(2.toHTML)
  //////////////////////////////////////////////////////////////////////////////////////////////////

  /*
  - Extend to new type
  - choose an implementation (importing the implicit or passing explicitly to the input)
  - super expressive
   */

  /*
  - type class itself = HTMLSerializer[T] { ... }
  - type class instances (some of which are implicit : IntSerializer)
  - conversion with implicit classes : HTMLEnrichment
   */

  // Context bounds :
  def htmlBoilerplate[T](content: T)(implicit serializer: HTMLSerializer[T]): String =
    s"<html><body>${content.toHTML(serializer)}</body></html>"

  def htmlSugar[T: HTMLSerializer](content: T): String =
    s"<html><body>${content.toHTML}</body></html>"
  // "T: HTMLSerializer" is a context bound

//  implicitly
  case class Permissions(mask: String)
  implicit val defaultPermission: Permissions = Permissions("0744")

  // in some other part of the code
  val standardPermissions = implicitly[Permissions] // to surface the value of an implicit in other part of the code, we use "implicitly"

  println(standardPermissions)

  def htmlSugarRemake[T: HTMLSerializer](content: T): String = {
    val serializer = implicitly[HTMLSerializer[T]]
    s"<html><body>${content.toHTML(serializer)}</body></html>"
  }
  // "T: HTMLSerializer" is a context bound
}
