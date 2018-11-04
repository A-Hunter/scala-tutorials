package com.scala.tutorials.p.strings

/**
  * Created by Ghazi Naceur on 04/11/2018.
  */
object String {

  def main(args: Array[String]): Unit = {
    val str = "Good morning"
    val time = 4.30
    println(str + time)
    println ("Hello - $time")
    println (s"Hello - $time") // interpolation as string
    println (f"Hello - $time") // interpolation as float
    println (f"Hello - $time%2.1f") // interpolation as float
    println (f"Hello - $time%2.2f") // interpolation as float
    println (f"Hello - $time%2.3f") // interpolation as float
    println (f"Hello - $str%.3s") // interpolation as float
    println (f"Hello - $str%.4s") // interpolation as float
    println (f"Hello - $str%.6s") // interpolation as float
    println (f"Hello - $str%.7s") // interpolation as float
  }

}
