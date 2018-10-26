package com.scala.tutorials.i.partially_applied_functions

import java.util.Date

/**
  * Created by Ghazi Naceur on 26/10/2018.
  */

/**
  * When you invoke a function, you're said to be applying the function to the arguments.
  * If you pass all the expected arguments, you have fully applied it. If you send only
  * a few arguments, then you get back a partially applied function. This gives you the
  * convenience of binding some arguments and leaving the rest to be filled in later.
  */
object Demo {
  def main(args: Array[String]) {
    val date = new Date
    log(date, "message 1")

    Thread.sleep(1000)
    log(date, "message 2")

    Thread.sleep(1000)
    log(date, "message 3")
  }

  def log(date: Date, message: String)  = {
    println(date + " ---- " + message)
  }
}
