package com.scala.lang.org.j.regular_expression_patterns

import scala.util.matching.Regex

/**
  * Created by Ghazi Naceur on 24/03/2019
  * Email: ghazi.ennacer@gmail.com
  */

object RegularExpressionPatterns extends App {

  val numberPattern: Regex = "[0-9]".r

  private def validatePassword(password: String) = {
    numberPattern.findFirstMatchIn(password) match {
      case Some(_) => println("Password OK")
      case None => println("Password must contain a number")
    }
  }
  validatePassword("23156pol")
  validatePassword("polgjhdj")

//  You can also search for groups of regular expressions using parentheses.
  val keyValPattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r
  val input: String =
    """background-color: #A03300;
      |background-image: url(img/header100.png);
      |background-position: top center;
      |background-repeat: repeat-x;
      |background-size: 2160px 108px;
      |margin: 0;
      |height: 108px;
      |width: 100%;""".stripMargin
  for (patternMatch <- keyValPattern.findAllMatchIn(input))
    println(s"key: ${patternMatch.group(1)} - value: ${patternMatch.group(2)}")
}
