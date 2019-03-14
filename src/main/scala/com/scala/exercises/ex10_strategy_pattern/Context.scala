package com.scala.exercises.ex10_strategy_pattern

/**
  * Created by Ghazi Naceur on 14/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object Context {
  type Strategy = (Int, Int) => Int

  class Context(strategy: Strategy) {
    def compute(x: Int, y: Int): Int = {
      strategy(x, y)
    }
  }

  val add: Strategy = _ + _
  val multiply: Strategy = _ * _
  val divide: Strategy = _ / _
  val minus: Strategy = _ - _

  def main(args: Array[String]): Unit = {
    println(add(6, 5))
    println(multiply(6, 5))
    println(divide(6, 5))
    println(minus(6, 5))

    println(new Context(add).compute(6, 5))
    println(new Context(multiply).compute(6, 5))
    println(new Context(divide).compute(6, 5))
    println(new Context(minus).compute(6, 5))
  }
}


