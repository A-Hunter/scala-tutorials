package com.scala.tutorials.t.regular_expressions

import scala.util.matching.Regex

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * Note − that every backslash appears twice in the string above. This is because
  * in Java and Scala a single backslash is an escape character in a string literal,
  * not a regular character that shows up in the string. So instead of ‘\’, you need
  * to write ‘\\’ to get a single backslash in the string.
  */
object Demo {
  def main(args: Array[String]) {

    val str = "Scala is Scalable and cool"
    val str2 = "ablaw is able1 and cool"

    // You can follow a string with `.r`, turning it into a `Regex`
    val pattern = "Scala".r
    // "findFirstIn" : returns an optional first matching string of this `Regex` in the given character sequence,
    //   or None if there is no match.
    println(pattern findFirstIn str)

    val pattern2 = new Regex("(S|s)cala")
    // "mkString" : displays all elements of this $coll in a string using a separator string.
    println((pattern2 findAllIn str).mkString(","))

    val pattern3 = "(S|s)cala".r
    // "replaceFirstIn" : replaces the first match by a string.
    println(pattern3 replaceFirstIn(str, "Java"))

    // "\\d+" : \d is a digit (a character in the range 0-9), and + means 1 or more times.
    //  So, \d+ is 1 or more digits.
    val pattern4 = new Regex("abl[ae]\\d+")
    println((pattern4 findAllIn str2).mkString(","))
  }
}
