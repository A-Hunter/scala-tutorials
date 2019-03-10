package com.scala.exercises.ex9_tennis

/**
  * Created by Ghazi Naceur on 10/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
case class Player(name: String) {
  var score: Int = 0
  def winBall: Int = {
    score += 1
    score
  }
  def initialize: Int = {
    score = 0
    score
  }
}
