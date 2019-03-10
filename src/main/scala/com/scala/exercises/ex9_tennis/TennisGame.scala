package com.scala.exercises.ex9_tennis

/**
  * Created by Ghazi Naceur on 10/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
case class TennisGame(player1: Player, player2: Player) {

  def getScore(player1: Player, player2: Player): String = {
    if (player1.score - player2.score >= 2 && player1.score >= 4) {
      player1.initialize
      player2.initialize
      player1.name + " won"
    } else if (player2.score - player1.score >= 2 && player2.score >= 4) {
      player2.name + " won"
    } else if (player1.score > player2.score) {
      "Avantage " + player1.name
    } else if (player1.score < player2.score) {
      "Avantage " + player2.name
    } else if (player1.score == player2.score) {
      "Deuce"
    } else {
      getIndividualScore(player1.score) + ", " + getIndividualScore(player2.score)
    }
  }

  def getIndividualScore(score: Int): String = {
    if (score == 0) {
      "love"
    } else if (score == 1) {
      "fifteen"
    } else if (score == 2) {
      "thirty"
    } else if (score == 3) {
      "forty"
    } else {
      "9h happen"
    }
  }
}
