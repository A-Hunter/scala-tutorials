package com.scala.tutorials.r.traits.geometry

/**
  * Created by Ghazi Naceur on 24/11/2018.
  */
trait Shape {

  def area: Int

  def name: String

  final def parentName: String = "Shape" // Can't be overridden
}
