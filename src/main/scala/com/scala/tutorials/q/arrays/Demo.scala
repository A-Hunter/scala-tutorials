package com.scala.tutorials.q.arrays

import Array._
/**
  * Created by Ghazi Naceur on 27/10/2018.
  */
object Demo {

  def main(args: Array[String]) {

    // First declaration
    var a : Array[String] = new Array[String](3)

    //Second declaration
    var b = new Array[String](3)

    var myList = Array(1.9, 2.9, 3.4, 3.5)

    // Print all the array elements
    for ( x <- myList ) {
      println( x )
    }

    // Summing all elements
    var total = 0.0

    for ( i <- 0 to (myList.length - 1)) {
      total += myList(i)
    }
    println("Total is " + total)

    // Finding the largest element
    var max = myList(0)

    for ( i <- 1 to (myList.length - 1) ) {
      if (myList(i) > max) max = myList(i)
    }

    println("Max is " + max)

    /********* 2-dimentional array **********/

    var myMatrix = ofDim[Int](3,3)

    // build a matrix
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        myMatrix(i)(j) = j;
      }
    }

    // Print two dimensional array
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }

    /********* concatenate arrays **********/
    var myList1 = Array(1.9, 2.9, 3.4, 3.5)
    var myList2 = Array(8.9, 7.9, 0.4, 1.5)

    var myList3 =  concat( myList1, myList2)

    // Print all the array elements
    for ( x <- myList3 ) {
      println( x )
    }

    /********* create array with range **********/

    // Print all the array elements
    for ( x <- myList1 ) {
      print( " " + x )
    }

    println()
    for ( x <- myList2 ) {
      print( " " + x )
    }
  }

}
