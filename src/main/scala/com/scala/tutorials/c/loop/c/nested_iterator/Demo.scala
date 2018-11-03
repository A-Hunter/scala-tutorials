package com.scala.tutorials.c.loop.c.nested_iterator

/**
  * Created by Ghazi Naceur on 03/11/2018.
  */
object Demo {

  def main(args: Array[String]): Unit = {
    /**
      * It is similar to :
      * for (int a = 0 ; a <= 10 ; a++){
      *     for (int b = 10 ; b <= 20 ; b++){
      *         ..........
      *     }
      * }
      */
//    for (a <- 1 to 10 ; b <- 10 to 20) yield println(a +"-"+ b)

    for (a <- 1 to 10 if a % 2 == 0; b <- 10 to 20 if b % 2 == 0) yield println(a +"-"+ b)
  }

}
