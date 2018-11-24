package com.scala.tutorials.b.classes.abstractClasses

/**
  * Created by Ghazi Naceur on 24/11/2018.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val mercedes = new Mercedes
    val audi = new Audi
    val bmw = new BMW

    val cars = List(mercedes,audi,bmw)
    cars.foreach(x=>{
      println(x.getClass)
      println(x.year)
      println(x.automatic)
      println(x.color)
    })
  }
}
