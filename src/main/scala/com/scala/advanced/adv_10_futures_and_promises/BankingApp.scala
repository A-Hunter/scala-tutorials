package com.scala.advanced.adv_10_futures_and_promises

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object BankingApp extends App {

  case class User(name: String)
  case class Transaction(sender: String, receiver: String, amount: Double, status: String)

  val name = "Bank"

  def fetchUser(name: String): Future[User] = Future {
    Thread.sleep(500)
    User(name)
  }

  def createTransaction(user: User, merchantName: String, amount: Double): Future[Transaction] = Future {
    Thread.sleep(1000)
    Transaction(user.name, merchantName, amount, "SUCCESS")
  }

  def purchase(userName: String, item: String, merchantName: String, cost: Double): String = {
    // fetch user from DB
    // create transaction
    // wait for the transaction to finish
    val transactionSatausFuture = for {
      user <- fetchUser(userName)
      transaction <- createTransaction(user, merchantName, cost)
    } yield transaction.status
    // Block until the future is complete : "Await.result(future, duration)"
    Await.result(transactionSatausFuture, 2.seconds) // 2.seconds : Implicit conversions with "import scala.concurrent.duration._"
    // We can use "Await.ready", but it will return the same Future as ready
  }

  println(purchase("Netero", "Renting a Zoldick backup", "Zen", 50000.0))
}
