package com.scala.exercises.ex7_berlin_clock

/**
  * Created by Ghazi Naceur on 09/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object BerlinClock {

  def extractHhMmSs(date: String): Array[String] = {
    date.split(":")
  }

  def numberOfOnUpLamps(value: Int): Int = {
    (value - (value % 5)) / 5
  }

  def numberOfOnDownLamps(value: Int): Int = {
    value % 5
  }

  def secondsLampState(value: Int): Boolean = {
    value % 2 == 0
  }

  def main(args: Array[String]): Unit = {
    val time = extractHhMmSs("21:55:47")

    val hh = time(0).toInt
    val mm = time(1).toInt
    val ss = time(2).toInt

    val convertedUpHours = numberOfOnUpLamps(hh)
    val convertedDownHours = numberOfOnDownLamps(hh)
    val convertedUpMinutes = numberOfOnUpLamps(mm)
    val convertedDownMinutes = numberOfOnDownLamps(mm)
    val isSecondsLampOn = secondsLampState(ss)

    println(convertedUpHours)
    println(convertedDownHours)
    println(convertedUpMinutes)
    println(convertedDownMinutes)
    println(isSecondsLampOn)
  }
}
