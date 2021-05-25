package com.scala.advanced.adv_8_intro_to_concurrency

import java.util.concurrent.Executors

object IntroToConcurrency extends App {
/**
  private val runnable = new Runnable {
    override def run(): Unit = println("Running in parallel")
  }

  val thread = new Thread(runnable)

  val otherThread = new Thread(() => println("Running in parallel"))

  thread.start()
  // gives the signal to the JVM to start a JVM thread, which plays on top of an OS thread

  runnable.run() // doesn't do anything parallel. Parallelism is triggered by "thread.start()", not "runnable.run()"

  thread.join() // blocks until a thread finishes running

  val thread1 = new Thread(() => (1 to 5).foreach(_ => println("hello")))
  val thread2 = new Thread(() => (1 to 5).foreach(_ => println("goodbye")))

  thread1.start()
  thread2.start()

  // Executors : to reuse threads
  val pool = Executors.newFixedThreadPool(10)
  pool.execute(() => println("Something in the thread pool"))

  pool.execute(() => {
    Thread.sleep(1000)
    println("Print after 1 second")
  })

  pool.execute(() => {
    Thread.sleep(1000)
    println("1 sec")
    Thread.sleep(1000)
    println("2 sec")
  })

//  pool.shutdown() // It will shutdown the calling thread
//  println(pool.isShutdown)
//  pool.execute(() => println("fkjf")) // Throws an exception in the calling thread. The pool is already closed

//  pool.shutdownNow() // It will shutdown the main thread (and throws an exception for all sleeping threads)

  // Prob 1 : Race condition
  def runInParallel = {
    var x = 0
    val threadA = new Thread(() => {
      x = 1
    })

    val threadB = new Thread(() => {
      x = 2
    })
    threadA.start()
    threadB.start()
    println(x)
    // This is a concurrency problem : 2 threads are trying to set the same memory zone at the same time
    // This is a race condition
  }
  for(_ <- 1 to 100) runInParallel
*/
  // Example 2 : Race condition
  class BankAccount(var amount: Int) {
    override def toString: String = "" + amount
  }

  def buy(account: BankAccount, thing: String, price: Int): Unit = {
    account.amount -= price
//    println("I've bought " + thing)
//    println("My account is now "+ account)
  }
  for (_ <- 1 to 1000) {
    val account = new BankAccount(50000)
    val threadC = new Thread(() => buy(account, "pc", 3000))
    val threadD = new Thread(() => buy(account, "smartphone", 4000))

    threadC.start()
    threadD.start()
    Thread.sleep(10)
    if (account.amount != 43000) println("What's going on ?? " + account.amount)
  }
/*
    Explanation :
      - threadC (pc) : 50000
        account = 50000 - 3000 = 47000
      - threadD (smartphone) : 50000
        account = 50000 - 4000 = 46000 // overwrites the memory of account.amount
*/

  // Solution 1 for race condition : synchronized()
  def buySafe(account: BankAccount, thing: String, price: Int): Unit = {
    account.synchronized {
      // No 2 threads can evaluate this at the same time
      account.amount -= price
      println("I've bought " + thing)
      println("My account is now " + account)
    }
  }

  for (_ <- 1 to 1000) {
    val account = new BankAccount(50000)
    val threadC = new Thread(() => buySafe(account, "pc", 3000))
    val threadD = new Thread(() => buySafe(account, "smartphone", 4000))

    threadC.start()
    threadD.start()
    Thread.sleep(10)
    if (account.amount != 43000) println("What's going on ?? " + account.amount)
  }

  // Solution 2 for race condition : @volatile
  // @volatile : annotated on a var or a val means that all reads and writes are synchronized
  class BankAccount2(@volatile var amount: Int) {
    override def toString: String = "" + amount
  }

  // synchronized( is more powerful than @volatile, because it gives the chance to control more code/statements inside it
}
