package com.scala.tutorials.h.nested_funtions

/**
  * Created by Ghazi Naceur on 04/11/2018.
  */
object Comparison {

  def main(args: Array[String]): Unit = {
    println(minimum(3, 4, 5))
    println(maximum(3, 4, 5))
    println(average(3, 4, 5))
  }

  def minimum(x: Int, y: Int, z: Int): Int ={
    def min(i: Int, j: Int): Int = {
      if (i < j) {
        i
      } else {
        j
      }
    }
    min(x, min(y,z))
  }


  def maximum(x:Int, y:Int, z:Int): Int ={
    def max(i:Int, j:Int): Int ={
      if (i > j){
        i
      } else {
        j
      }
    }
    max(x, max(y, z))
  }

  def average(x:Int, y:Int, z:Int): Int ={
    def sum(i:Int, j:Int): Int ={
      i+j
    }
    sum(x, sum(y,z))/3
  }


}
