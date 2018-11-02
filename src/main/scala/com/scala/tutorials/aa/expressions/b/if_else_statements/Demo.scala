package com.scala.tutorials.aa.expressions.b.if_else_statements

/**
  * Created by Ghazi Naceur on 02/11/2018.
  */
object Demo {

  def main(args: Array[String]): Unit = {

    val x = 3.3
    val threshold = 30
    val res: Unit = x match {
      case s if  s > threshold => println("Higher")
      case s if  s <= threshold => println("Lower")
      case s => "Check your input"
    }
  }

}
