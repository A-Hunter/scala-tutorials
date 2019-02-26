package com.scala.tutorials.v.extractors

/**
  * Created by Ghazi Naceur on 27/10/2018.
  */

/**
  * Pattern Matching with Extractors :
  * When an instance of a class is followed by parentheses with a list of zero or more
  * parameters, the compiler invokes the apply method on that instance. We can define
  * apply both in objects and in classes.
  * As mentioned above, the purpose of the unapply method is to extract a specific value
  * we are looking for. It does the opposite operation apply does. When comparing an
  * extractor object using the match statement the unapply method will be automatically
  * executed.
  */
object Demo2 {
  def main(args: Array[String]) {
    // Demo2(5) : When an instance of a class is followed by parentheses with a list of zero or more
    //  parameters, the compiler invokes the apply method on that instance.
    val x = Demo2(5)
    println(x)

    x match {
        // Demo2(num) : When comparing an
      //     extractor object using the match statement the unapply method will be automatically
      //     executed.
      case Demo2(num) => println(x + " is bigger two times than " + num)

      //unapply is invoked
      case _ => println("i cannot calculate")
    }
  }

  def apply(x: Int): Int = x * 2

  def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
}
