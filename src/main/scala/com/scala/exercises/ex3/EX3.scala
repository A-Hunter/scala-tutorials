package com.scala.exercises.ex3

import scala.collection.mutable.ListBuffer

/**
  * Created by Ghazi Naceur on 07/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object EX3 {

  def findPeopleIn(city: String, people: List[People]): ListBuffer[People] = {
    val found = ListBuffer[People]()
    for (person <- people) {
      for (address <- person.addresses) {
        if (address.city == city) {
          found += person
        }
      }
    }
    println("found : " + found)
    found
  }

  // This method is better than the first one
  def locatePeopleIn(city: String, people: List[People]): List[People] = {
    val peoples = for {
      person <- people
      address <- person.addresses
      if address.city == city
    } yield person
    println("peoples : " + peoples)
    peoples
  }

  def main(args: Array[String]): Unit = {
    val addresses1: List[Address] = List(Address("City1"), Address("City2"), Address("City3"))
    val addresses2: List[Address] = List(Address("City4"), Address("City1"), Address("City6"))
    val addresses3: List[Address] = List(Address("City7"), Address("City8"), Address("City"))
    //    addresses Address("City1")
    val peps = List[People](People(addresses1), People(addresses2), People(addresses3))
    val peps2 = List[People](People(addresses1), People(addresses2), People(addresses3))
    findPeopleIn("City1", peps)
    locatePeopleIn("City1", peps2)
  }
}
