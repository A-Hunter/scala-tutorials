package com.scala.tutorials.i.partially_applied_functions

/**
  * Created by Ghazi Naceur on 04/11/2018.
  */
/**
  * When you invoke a function, you're said to be applying the function to the arguments.
  * If you pass all the expected arguments, you have fully applied it. If you send only
  * a few arguments, then you get back a partially applied function. This gives you the
  * convenience of binding some arguments and leaving the rest to be filled in later.
  *
  * Partially applied functions ==> function reusability
  */
object Salary {

  def calculateSalary(baseSalary: Double, bonus: Double): Double = {
    baseSalary + bonus
  }

  val fixedSalaries: Double => Double = calculateSalary(400, _: Double)

  def main(args: Array[String]): Unit = {

    val salary1: Double = calculateSalary(500, 200)
    val salary2 = fixedSalaries(200)
    val salary3 = fixedSalaries(300)

    println(salary1)
    println(salary2)
    println(salary3)
  }

}
