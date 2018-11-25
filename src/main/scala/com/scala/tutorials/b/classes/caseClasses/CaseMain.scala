package com.scala.tutorials.b.classes.caseClasses

/**
  * Created by Ghazi Naceur on 25/11/2018.
  */
object CaseMain extends App {

  val book1 = Book("uij-123456789")
  val book2 = Book("rty-123456789")
  val book3 = book2.copy()
  val book4 = book2

  println(book1.isbn)
  println(book2.isbn)
  println(book3.isbn)
  println(book4.isbn)

  // compared by structure not by reference
  println(book2 == book3)
  println(book2 == book4)
}
