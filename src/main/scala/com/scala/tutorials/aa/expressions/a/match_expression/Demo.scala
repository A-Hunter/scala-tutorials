package com.scala.tutorials.aa.expressions.a.match_expression

/**
  * Created by Ghazi Naceur on 02/11/2018.
  */

/**
  * This is a match expression example
  */
object Demo {

  def main(args: Array[String]) {

    val day: String = "Mondakjy"

    // Unit is equivalent to 'void' in Java
    val week: Unit = day match {
      case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" =>
        "Work"
        println("Work")

      case "Saturday" | "Sunday" =>
        "Weekend"
        println("Weekend")

      case other =>
        println("The provided input is not a day")

      //  We can write as well
      //      case _ =>
      //        println("a wildcard value")
    }
  }

}
