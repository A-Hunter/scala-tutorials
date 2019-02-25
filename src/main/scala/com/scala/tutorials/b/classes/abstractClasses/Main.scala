package com.scala.tutorials.b.classes.abstractClasses

/**
  * Created by Ghazi Naceur on 24/11/2018.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val cars = List(new Mercedes, new Audi, new BMW)
    cars.foreach(x => {
      println(">>> " + x.getClass.getSimpleName)
      println(x.year)
      println(x.automatic)
      println(x.color)
    })
  }
}
