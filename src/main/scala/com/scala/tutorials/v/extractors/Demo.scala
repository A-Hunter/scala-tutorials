package com.scala.tutorials.v.extractors

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * An extractor in Scala is an object that has a method called unapply as one of its members.
  * The purpose of that unapply method is to match a value and take it apart. Often,
  * the extractor object also defines a dual method apply for building values, but this is
  * not required.
  * Example :
  * Let us take an example of object defines both apply and unapply methods. The apply method
  * has the same meaning as always: it turns Test into an object that can be applied to
  * arguments in parentheses in the same way a method is applied. So you can write Test
  * ("Zara", "gmail.com") to construct the string "Zara@gmail.com".
  * The unapply method is what turns Test class into an extractor and it reverses the
  * construction process of apply. Where apply takes two strings and forms an email address
  * string out of them, unapply takes an email address and returns potentially two strings:
  * the user and the domain of the address.
  * The unapply must also handle the case where the given string is not an email address.
  * That's why unapply returns an Option-type over pairs of strings. Its result is either
  * Some (user, domain) if the string str is an email address with the given user and
  * domain parts, or None, if str is not an email address.
  */
object Demo {
  def main(args: Array[String]) {
    println ("Apply method : " + apply("Zara", "gmail.com"));
    println ("Unapply method : " + unapply("Zara@gmail.com"));
    println ("Unapply method : " + unapply("Zara Ali"));
  }

  // The injection method (optional)
  def apply(user: String, domain: String) = {
    user +"@"+ domain
  }

  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"

    if (parts.length == 2){
      Some(parts(0), parts(1))
    } else {
      None
    }
  }
}
