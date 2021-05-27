package com.scala.advanced.adv_12_implicits

object OrganizingImplicits extends App {

  implicit val reverseOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)
//  implicit val normalOrdering: Ordering[Int] = Ordering.fromLessThan(_ < _)
  println(List(1,3,5,2,6,4).sorted)
  // "reverseOrdering" will override the implicit ordering provided by ".sorted"

  // scala.Predef

  /*
  Implicits used as implicit parameters :
    - val/var
    - object
    - accessor methods : defs without parentheses (otherwise it will be not considered as an implicit value, and won't perform any action)
   */

  case class Person(name: String, age: Int)

  val persons = List(
    Person("Isaac", 125),
    Person("Itachi",25),
    Person("Shisui",28),
    Person("Hisoka",32),
    Person("Takamora",31)
  )

  // 1 : works
//  implicit val orderingPersons: Ordering[Person] = Ordering.fromLessThan((p1, p2) => p1.name.compareTo(p2.name) < 0)

  // 2 : works
//  object Person {
//    implicit val orderingPersons: Ordering[Person] = Ordering.fromLessThan((p1, p2) => p1.name.compareTo(p2.name) < 0)
//  }

  // 3 : works
  import AlphabeticNameOrdering._
  println(persons.sorted)

  /*
  Implicit scope :
    - normal scope : local scope (same class or companion object)
    - imported scope
    - companions of all types involved in the method signature
   */

  object AlphabeticNameOrdering {
    implicit val namePersons: Ordering[Person] = Ordering.fromLessThan((p1, p2) => p1.name.compareTo(p2.name) < 0)
  }

  object AgeOrdering {
    implicit val agePersons: Ordering[Person] = Ordering.fromLessThan(_.age < _.age)
  }

  // Example :
  case class Purchase(nUnits: Int, unitPrice: Double)
  object Purchase {
    implicit val totalPriceOrdering: Ordering[Purchase] = Ordering.fromLessThan((x,y) => x.nUnits * x.unitPrice < y.nUnits * y.unitPrice)
    implicit val unitCountOrdering: Ordering[Purchase] = Ordering.fromLessThan(_.nUnits < _.nUnits)
    implicit val unitPriceOrdering: Ordering[Purchase] = Ordering.fromLessThan(_.unitPrice < _.unitPrice)
  }
}
