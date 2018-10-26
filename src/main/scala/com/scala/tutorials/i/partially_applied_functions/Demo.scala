package com.scala.tutorials.i.partially_applied_functions

import java.util.Date

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */
object Demo {
  def main(args: Array[String]) {
    val date = new Date
    log(date, "message1")

    Thread.sleep(1000)
    log(date, "message2")

    Thread.sleep(1000)
    log(date, "message3")
  }

  def log(date: Date, message: String)  = {
    println(date + " ---- " + message)
  }
}
