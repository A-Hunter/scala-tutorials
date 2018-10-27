package com.scala.tutorials.q.arrays.maps

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */
object Demo {
  def main(args: Array[String]) {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    val nums: Map[Int, Int] = Map()
    println( "Keys in colors : " + colors.keys )
    println( "Values in colors : " + colors.values )
    println( "Check if colors is empty : " + colors.isEmpty )
    println( "Check if nums is empty : " + nums.isEmpty )


    val colors1 = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF", "yellow" -> "#FFFF00", "red" -> "#FF0000")
    // use two or more Maps with ++ as operator
    var colors3 = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors3 )
    // use two maps with ++ as method
    colors3 = colors1.++(colors2)
    println( "colors1.++(colors2)) : " + colors3 )

    colors.keys.foreach{ i =>
      print( "Key = " + i )
      println(" Value = " + colors(i) )}


    if( colors.contains( "red" )) {
      println("Red key exists with value :"  + colors("red"))
    } else {
      println("Red key does not exist")
    }

    if( colors.contains( "maroon" )) {
      println("Maroon key exists with value :"  + colors("maroon"))
    } else {
      println("Maroon key does not exist")
    }
  }
}
