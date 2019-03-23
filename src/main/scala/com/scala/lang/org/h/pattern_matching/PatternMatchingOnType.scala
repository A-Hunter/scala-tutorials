package com.scala.lang.org.h.pattern_matching

/**
  * Created by Ghazi Naceur on 23/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

abstract class Device
case class Phone(model: String) extends Device {
  def screenOff = "Turning screen off"
}
case class Computer(model: String) extends Device {
  def screenSaverOn = "Turning screen saver on..."
}

// This is useful when the case needs to call a method on the pattern. It is a convention to use the first letter of
// the type as the case identifier (p and c in this case).
object PatternMatchingOnType extends App {

  val device = Phone("nokia")

  def goIdle(device: Device) = device match {
    case p: Phone => println(p.screenOff)
    case c: Computer => println(c.screenSaverOn)
  }

  goIdle(device)
}
