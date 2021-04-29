package com.scala.advanced.adv_4_currying_and_partially_applied_functions

object CurriesPAF extends App {

  // curried functions
  val curriedFunction: Int => Int => Int =
    x => y => x + y

  val add3 = curriedFunction(3)
  println(add3(5))
  println(curriedFunction(3)(5))

  def curriedMethod(x: Int)(y: Int): Int = x + y

  println(curriedMethod(3)(5))

  def inc(x: Int) = x + 1
  List(1,2,3).map(inc) // after ETA-EXPANSION it will be like this : .map(x => inc(x))

  // Partial function applications
  val add5 = curriedMethod(5) _ // After adding the underscore, the compiler will perform an ETA-EXPANSION, and
                                // our function will be "Int => Int" function
  println(add5(2))

  val simpleAddFunction = (x: Int, y: Int) => x + y
  def simpleAddMethod(x: Int, y: Int) = x + y
  def curriedAddMethod(x: Int)(y: Int) = x + y

  val add71 = (x: Int) => simpleAddFunction(7, x)
  val add72 = (x: Int) => simpleAddMethod(7, x)
  val add73 = (_: Int) => curriedAddMethod(7) _ // partially applied function (PAF)
  val add74 = curriedAddMethod(7) _ // partially applied function (PAF)
  val add75 = curriedAddMethod(7)(_) // partially applied function (PAF)

  val add76 = simpleAddFunction.curried(7) // .curried provided by scala (for functions)
  val add77 = simpleAddMethod(7, _: Int) // Alternative syntax for turning methods into function values
                              // "_: Int" forces the compiler to do an ETA-EXPANSION == "y => simpleAddMethod(7, y)"
  val add78 = simpleAddFunction(7, _: Int) // ETA-EXPANSION as well

  def concatenator(a: String, b: String, c: String) = a + b + c
  val insertName = concatenator("Something ", _: String, " orElse") // x: String => concatenator("Something", x, "orElse")
  println(insertName("here"))

  val overrideName = concatenator("Hello ", _: String, _: String) // (x: String, y: String) => concatenator("Hello ", x, y)
  println(overrideName("there ", "!"))

  def curriedFormatter(formatter: String)(number: Double) = formatter.format(number)
  val numbers = List(Math.PI, Math.E, 1, 9.7, 1.2e-12)
  private val form42f = curriedFormatter("%4.2f") _ // lift
  private val form86f = curriedFormatter("%8.6f") _ // lift
  private val form1412f = curriedFormatter("%14.12f") _ // lift

  println(numbers.map(form42f))
  println(numbers.map(curriedFormatter("%4.2f"))) // eta-expansion
  println(numbers.map(form86f))
  println(numbers.map(curriedFormatter("%8.6f"))) // eta-expansion
  println(numbers.map(form1412f))
  println(numbers.map(curriedFormatter("%14.12f"))) // eta-expansion

  def byName(n: Int) = n + 1
  def byFunction(f: () => Int) = f() + 1

  def method: Int = 42
  def parenthesisMethod(): Int = 42

  println("By name : ")
  byName(23) // OK
  byName(method) // OK, because method will be evaluated to its value (42)

  byName(parenthesisMethod()) // OK
  byName(parenthesisMethod) // OK, but be aware ===> byName(parenthesisMethod()), byName will use the value of the function
  // parenthesisMethod, which is 42, and will not use the function parenthesisMethod
  // itself (as calling parenthesisMethod)
  // There is a distinction between byName parameters (n: Int) and byFunction parameters (f: () => Int)

  //  byName(() => 42) NOK, because here we're declaring a lamnbda/function as a parameter
  byName((() => 42)()) // OK, because here we're calling a lambda/function (not like the previous example)
  //  byName(parenthesisMethod _) // NOK, because "parenthesisMethod _" is an expression, which is a function value (not a substitute to a byName parameter)

  println("By function : ")
//  byFunction(45) // NOK, we're expecting a lambda
//  byFunction(method) // NOK, because it's evaluated to its value, NO ETA-EXPANSION
  byFunction(parenthesisMethod) // OK, without parenthesis , ETA-EXPANSION
  byFunction(parenthesisMethod _) // OK, the parenthesis are unnecessary. The compiler can figure out that eta-expansion is needed without calling it explicitly with "_"
  byFunction(() => 46) // OK, works as expected, because it's a function value


}
