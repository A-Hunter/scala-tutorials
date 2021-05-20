package com.scala.advanced.adv_5_partial_functions

object PartialFcts extends App {

  val bot= new PartialFunction[String, String] {
    override def apply(x: String): String = x match {
      case "who are you ?" => "I am bot"
      case "version ?" => "1.0"
      case "date ?" => "28/04/2021"
      case "status ?" => "running"
    }

    override def isDefinedAt(x: String): Boolean =
      x == "who are you ?" || x == "version ?" || x == "date ?" || x == "status ?"
  }

  scala.io.Source.stdin.getLines().map(bot).foreach(println)
}
