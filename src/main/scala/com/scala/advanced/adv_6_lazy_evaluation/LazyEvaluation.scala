package com.scala.advanced.adv_6_lazy_evaluation

object LazyEvaluation extends App {

  // lazy :  delays the evaluation of values
//  lazy val x: Int = throw new RuntimeException("SHT !")

  lazy val x: Int = {
    println("something")
    42
  }
  println(x) // something \n 42
  println(x) // 42 => x is lazy, so it will evaluated once (in the first call), after that it will return the last value

  def sideEffectCondition: Boolean = {
    println("side effect")
    true
  }

  def simpleCondition: Boolean = false

  lazy val lazyCondition = sideEffectCondition

  println(if (simpleCondition && lazyCondition) "yes" else "no") // At this stage, the side effect "println("side effect")"
  // in the method "sideEffectCondition", because "lazyCondition" is not evaluated unless it is needed, and "simpleCondition"
  // has the value "false", so the Runtime did not evaluate "lazyCondition" and used the value "false" of "simpleCondition"
  // Be careful, if you implement side effects with lazy values

  // In conjuction with call by name :
  def callByName(n: => Int): Int = n + n + n + 1
  def retrieveMagicValue: Int = {
    // Something with side effect or long computation
    println("Evaluating ...")
    Thread.sleep(1000)
    42
  }

  println(callByName(retrieveMagicValue)) // "n" in "callByName(n: => Int)" method will be evaluated 3 times
  // => We should evaluated it once => We can reimplement "callByName" method to use lazy value, for input to be evaluated once
  // => Implementing a "call by need"
  def callByNeed(n: => Int): Int = {
    // Call by need
    lazy val t: Int = n
    t + t + t + 1
  }
  println(callByNeed(retrieveMagicValue))

  // Filtering lazy vals
  def lessThan30(i: Int): Boolean = {
    println(s"$i is less than 30 ?")
    i < 30
  }
  def greaterThan30(i: Int): Boolean = {
    println(s"$i is greater than 30 ?")
    i > 30
  }

  val numbers = List(1,25,40,3,10)
  val lt30 = numbers.filter(lessThan30)
  println(lt30)
  val gt30 = numbers.filter(greaterThan30)
  println(gt30)

  println("Lazy :")
  val lt30Lazy = numbers.withFilter(lessThan30) // .withFilter method uses lazy values under the hood.
                                                  // It evaluates values on "by need" basis
  println(lt30Lazy)
  val gt30Lazy = numbers.withFilter(greaterThan30)
  println(gt30Lazy)

  lt30Lazy.foreach(println)
  gt30Lazy.foreach(println)

  // for-comprehensions uses .withFilter with gards
  val res1 = for {
    a <- List(1,2,3) if a % 2 == 0
  } yield a + 1
  // This is translated to :
  val res2 = List(1,2,3).withFilter(_ % 2 == 0).map(_ + 1)

  println(res1)
  println(res2)
}
