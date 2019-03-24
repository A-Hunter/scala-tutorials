package com.scala.lang.org.k.extractor_objects

import scala.util.Random

/**
  * Created by Ghazi Naceur on 24/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
// The apply method is like a constructor which takes arguments and creates an object.
// The unapply takes an object and tries to give back the arguments.
object CustomerID {
  def apply(name: String) = s"$name--${Random.nextLong}"
  def unapply(customerID: String): Option[String] = {
    val name = customerID.split("--").head
    if (name.nonEmpty) Some(name) else None
  }
}

object ExtractorObjects extends App {

//  The apply method creates a CustomerID string from a name.
//  This is shorthand syntax for calling CustomerID.apply("Sukyoung")
  val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908

  customer1ID match {
//  We’re calling the unapply method.
    case CustomerID(name) => println(name)  // prints Sukyoung
    case _ => println("Could not extract a CustomerID")
  }


  val customer2ID = CustomerID("azerty")
  val CustomerID(name) = customer2ID
  println(name)  // prints Nico
  // It is similar to :
  val name2 = CustomerID.unapply(customer2ID).get
  println(name2)
}
