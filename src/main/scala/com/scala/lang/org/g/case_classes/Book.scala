package com.scala.lang.org.g.case_classes

/**
  * Created by Ghazi Naceur on 21/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
case class Book(isbn: String)

case class Message(sender: String, recipient: String, body: String)

object Book extends App {
  val book1 = Book("123-456-789")
  val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
  println(message1.sender)

  // Comparison
  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val messagesAreTheSame: Boolean = message2 == message3  // true
  println(messagesAreTheSame)

  // Copying
  val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
  val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
  println(message5.sender)  // travis@washington.us
  println(message5.recipient) // claire@bourgogne.fr
  println(message5.body)  // "Me zo o komz gant ma amezeg" : The body of message4 was copied directly.

}