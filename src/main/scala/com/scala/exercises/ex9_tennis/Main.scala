package com.scala.exercises.ex9_tennis

/**
  * Created by Ghazi Naceur on 10/03/2019
  * Email: ghazi.ennacer@gmail.com
  */
object Main {


  def main(args: Array[String]): Unit = {
    val player1: Player = Player("Player 1")
    val player2: Player = Player("Player 2")
    val game: TennisGame = TennisGame(player1, player2)
    println(game.getScore(player1, player2))
    player1.winBall
    println(game.getScore(player1, player2))
    println(game.getIndividualScore(player1.score)+", "+ game.getIndividualScore(player2.score))
    player2.winBall
    println(game.getScore(player1, player2))
    println(game.getIndividualScore(player1.score)+", "+ game.getIndividualScore(player2.score))
    player1.winBall
    println(game.getScore(player1, player2))
    println(game.getIndividualScore(player1.score)+", "+ game.getIndividualScore(player2.score))
    player2.winBall
    println(game.getScore(player1, player2))
    println(game.getIndividualScore(player1.score)+", "+ game.getIndividualScore(player2.score))
    player1.winBall
    player1.winBall
    player1.winBall
    player1.winBall
    println(game.getScore(player1, player2))
  }
}
