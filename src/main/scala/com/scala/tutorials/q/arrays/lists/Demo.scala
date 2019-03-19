package com.scala.tutorials.q.arrays.lists

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */
object Demo {
  def main(args: Array[String]) {
    val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
    val nums = Nil

    println("Head of fruit : " + fruit.head)
    println("Tail of fruit : " + fruit.tail)
    println("Check if fruit is empty : " + fruit.isEmpty)
    println("Check if nums is empty : " + nums.isEmpty)

    // List of Integers
    val numbers: List[Int] = List(1, 2, 3, 4)

    // Empty List.
    val empty: List[Nothing] = List()

    // Two dimensional list
    val dim: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )

    // List of Integers
    val numbs = 1 :: (2 :: (3 :: (4 :: Nil)))

    // Empty List.
    val emptiness = Nil

    // Two dimensional list
    val dims = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil


    val fr = List.fill(3)("apples") // Repeats apples three times.
    println("fruit : " + fr)

    val num = List.fill(10)(2) // Repeats 2, 10 times.
    println("num : " + num)

    // Creates 6 elements using the given function.
    val squares = List.tabulate(6)(n => n * n)
    println("squares : " + squares)

    val mul = List.tabulate(4, 5)(_ * _)
    println("mul : " + mul)

    val sum = numbers.reduce(_ + _) // equivalent to "sum"
    val sum2 = numbers.sum
    println("The sum of 1+2+3+4 = " + sum)
    println("The sum of 1+2+3+4 = " + sum2)

    println("Before reverse fruit : " + fruit)
    println("After reverse fruit : " + fruit.reverse)
  }
}
